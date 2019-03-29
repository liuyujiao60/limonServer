package com.limon.parameter;

import com.limon.core.request.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewInfoQueryParameter {

    private String categoryId;
    private String viewTopicColumnId;
    private Page page;
}
