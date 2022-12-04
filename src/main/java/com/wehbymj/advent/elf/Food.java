package com.wehbymj.advent.elf;


import lombok.*;
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Food {

    @NonNull
    @Getter
    private final String name;

    @NonNull
    @Getter
    private final int calories;
}
