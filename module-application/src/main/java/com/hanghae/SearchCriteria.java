package com.hanghae;

import com.hanghae.common.enums.SearchMatchType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SearchCriteria<T> {
    private T value;
    private SearchMatchType type;

    public SearchCriteria(T value, SearchMatchType type) {
        this.value = value;
        this.type = type;
    }
}
