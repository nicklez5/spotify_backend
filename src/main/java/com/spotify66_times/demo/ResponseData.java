package com.spotify66_times.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;
}
