package com.site.springMVC.repository;

import com.site.springMVC.entity.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<FileUpload,Integer> {
}
