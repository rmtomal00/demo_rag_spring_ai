package team.demo.response;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ApiResponse<T> {

    public static <T> ResponseEntity<Map<String, Object>> success(T data, @NonNull String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", HttpStatus.OK.value());
        map.put("data", data);
        map.put("message", message);
        map.put("err", false);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
    }

    public static <T> ResponseEntity<Map<String, Object>> success() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", HttpStatus.OK.value());
        map.put("message", "Success");
        map.put("err", false);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(map);
    }

    public static <T> ResponseEntity<Map<String, Object>> error(@NonNull T data, String message, @NonNull HttpStatus status) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", status.value());
        map.put("data", data);
        map.put("message", message != null ? message : "Internal Server Error");
        map.put("err", true);
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(map);
    }

    public static <T> ResponseEntity<Map<String, Object>> error(String message) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("message", message);
        map.put("err", true);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(map);
    }
}
