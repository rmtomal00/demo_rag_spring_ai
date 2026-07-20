package team.demo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import team.demo.response.ApiResponse;
import team.demo.services.RagChatService;
import team.demo.services.RagContentManageService;

@RestController
@RequestMapping("/api/v1/qdrant")
@RequiredArgsConstructor
public class UploadDataController extends ExceptionHandlerControllers {

    private final RagContentManageService ragContentManageService;
    private final RagChatService ragChatService;

    @PostMapping("/upload-data")
    public ResponseEntity<?> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("File can't be null");
        }
        ragContentManageService.saveFileToVector(file);
        return ApiResponse.success();
    }

    @GetMapping("/chat")
    public ResponseEntity<?> chat(@RequestParam("message")  String message) {
        System.out.println(message);
        return ApiResponse.success(ragChatService.chat(message), "success");
    }
}
