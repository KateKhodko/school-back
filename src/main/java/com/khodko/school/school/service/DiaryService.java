package com.khodko.school.school.service;

import com.khodko.school.school.model.Homework;
import com.khodko.school.school.model.Lesson;
import com.khodko.school.school.model.Mark;
import com.khodko.school.school.model.Student;
import com.khodko.school.school.model.request.GetDiaryPageRequest;
import com.khodko.school.school.model.response.DiaryEntry;
import com.khodko.school.school.repository.HomeworkRepository;
import com.khodko.school.school.repository.LessonRepository;
import com.khodko.school.school.repository.MarkRepository;
import com.khodko.school.school.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiaryService {

    private final LessonRepository lessonRepository;
    private final MarkRepository markRepository;
    private final HomeworkRepository homeworkRepository;
    private final StudentRepository studentRepository;

    public Map<Integer, List<DiaryEntry>> getDiaryPage(GetDiaryPageRequest getDiaryPageRequest) {

        Map<Integer, List<DiaryEntry>> weekSchedule = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            Student student = studentRepository.findById(getDiaryPageRequest.getStudentId()).get();

            int weekDay = i + 1;
            List<Lesson> lessonsPerDay = getLessons(student, weekDay);

            LocalDate weekDayDate = getDiaryPageRequest.getStartDate().plusDays(i);
            List<DiaryEntry> diaryEntries = new ArrayList<>();
            lessonsPerDay.forEach(lesson -> {
                DiaryEntry diaryEntry = new DiaryEntry();
                diaryEntry.setLesson(lesson);

                Optional<Homework> optionalHomework = getHomework(weekDayDate, lesson);
                optionalHomework.ifPresent(diaryEntry::setHomework);

                Optional<Mark> optionalMark = getMark(student, weekDayDate, lesson);
                optionalMark.ifPresent(diaryEntry::setMark);

                diaryEntries.add(diaryEntry);
            });
            weekSchedule.put(weekDay, diaryEntries);
        }

        return weekSchedule;
    }

    private List<Lesson> getLessons(Student student, int weekDay) {
        List<Lesson> lessonsPerDay = lessonRepository.findAll().stream().filter(lesson ->
                        lesson.getWeekDay() == weekDay
                                && lesson.getForm().equals(student.getForm()))
                .sorted(this::compareDates).collect(Collectors.toList());
        return lessonsPerDay;
    }

    private Optional<Mark> getMark(Student student, LocalDate weekDayDate, Lesson lesson) {
        Optional<Mark> optionalMark = markRepository.findAll().stream().filter(mark ->
                        mark.getLesson().equals(lesson)
                                && mark.getDate().equals(weekDayDate)
                                && mark.getStudent().equals(student))
                .findFirst();
        return optionalMark;
    }

    private Optional<Homework> getHomework(LocalDate weekDayDate, Lesson lesson) {
        Optional<Homework> optionalHomework = homeworkRepository.findAll().stream().filter(homework ->
                        homework.getDate().equals(weekDayDate) &&
                                homework.getLesson().equals(lesson))
                .findFirst();
        return optionalHomework;
    }


    private int compareDates(Lesson lesson1, Lesson lesson2) {
        String startTime1 = lesson1.getStartTime();
        String startTime2 = lesson1.getStartTime();

        int[] time1 = parseTime(startTime1);
        int[] time2 = parseTime(startTime2);

        if (time1[0] == time2[0]) {
            return time1[1] - time2[1];
        }

        return time1[0] - time2[0];
    }

    private int[] parseTime(String time) {
        String[] split = time.split(":");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }
}
