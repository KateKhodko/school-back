package com.khodko.school.school.model.response;

import com.khodko.school.school.model.Homework;
import com.khodko.school.school.model.Lesson;
import com.khodko.school.school.model.Mark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DiaryEntry {

    private Lesson lesson;
    private Homework homework;
    private Mark mark;
}
