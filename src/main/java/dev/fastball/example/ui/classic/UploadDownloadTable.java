package dev.fastball.example.ui.classic;

import dev.fastball.core.annotation.*;
import dev.fastball.core.component.DataResult;
import dev.fastball.core.component.DownloadFile;
import dev.fastball.core.component.RecordActionFilter;
import dev.fastball.meta.basic.PopupType;
import dev.fastball.example.common.model.Employee;
import dev.fastball.example.common.model.UserQuerier;
import dev.fastball.example.common.repo.EmployeeRepository;
import dev.fastball.example.ui.simple.EmployeeForm;
import dev.fastball.ui.components.table.SearchTable;
import dev.fastball.ui.components.table.param.TableSearchParam;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Objects;

/**
 * @author gr@fastball.dev
 * @since 2023/1/26
 */
@UIComponent
@RequiredArgsConstructor
public class UploadDownloadTable implements SearchTable<Employee, UserQuerier> {

    private final EmployeeRepository employeeRepo;

    @Override
    public DataResult<Employee> loadData(TableSearchParam<UserQuerier> querier) {
        Collection<Employee> data = employeeRepo.findByQuerier(querier);
        return DataResult.build(data);
    }

    @Action(key = "upload", name = "上传")
    public void upload(MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getContentType());
        IOUtils.copy(multipartFile.getInputStream(), System.out);
    }

    @Action(key = "download", name = "下载")
    public DownloadFile download(TableSearchParam<UserQuerier> querier) throws IOException {
        System.out.println(querier);
        return DownloadFile.builder().fileName("test.txt").inputStream(new ByteArrayInputStream("测试文件".getBytes(StandardCharsets.UTF_8))).contentType("text/plain").build();
    }

}
