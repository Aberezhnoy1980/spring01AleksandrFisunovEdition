package ru.home.statistic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomsDeclarationStatusEnum {
//    FILED("Подана"),
//    REGISTERED("Зарегистрирована"),
//    WIP("В оформлении"),
//    INSPECTION("На осмотре"),
//    RELEASE("Выпуск"),
//    RELEASE_DENIED("Отказ в выпуске");

    RELEASED("Выпущена"), CANCELED("Отказ в выпуске"), SUBMITTED("Подана");

    final String rusName;
}
