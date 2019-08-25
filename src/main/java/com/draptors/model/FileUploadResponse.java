package com.draptors.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class FileUploadResponse {
    @SerializedName("file_name")
    @Expose
    private String fileName;

    @SerializedName("file_download_uri")
    @Expose
    private String fileDownloadUri;

    @SerializedName("status")
    @Expose
    private String status;
}
