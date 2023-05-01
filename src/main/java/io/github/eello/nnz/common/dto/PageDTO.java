package io.github.eello.nnz.common.dto;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PageDTO {

    private Boolean isFirst;
    private Boolean isLast;
    private Boolean isEmpty;
    private Long totalElements;
    private Integer totalPages;
    private List<?> content;

    public static PageDTO of(Page<?> page) {
        PageDTO dto = new PageDTO();
        dto.isFirst = page.isFirst();
        dto.isLast = page.isLast();
        dto.isEmpty = page.isEmpty();
        dto.totalElements = page.getTotalElements();
        dto.totalPages = page.getTotalPages();
        dto.content = page.getContent();
        return dto;
    }

//    public static PageDTO of(Page<?> page, Function mapper) {
//        PageDTO<Page<?>> dto = new PageDTO<>();
//        dto.isFirst = page.isFirst();
//        dto.isLast = page.isLast();
//        dto.isEmpty = page.isEmpty();
//        dto.totalElements = page.getTotalElements();
//        dto.totalPages = page.getTotalPages();
//        dto.content = (List<?>) page.getContent().stream().map(mapper).collect(Collectors.toList());
//        return dto;
//    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
