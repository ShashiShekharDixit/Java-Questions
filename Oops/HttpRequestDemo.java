import java.util.HashMap;
import java.util.Map;
class HttpRequest {
    private final String url;
    private final String method;
    private final Map<String, String> headers;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
    }

    public String toString() {
        return "HttpRequest: " + method + " " + url + " Headers: " + headers;
    }
    public static class Builder {
        private String url;
        private String method = "GET";
        private Map<String, String> headers = new HashMap<>();

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder header(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
public class HttpRequestDemo {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.Builder()
                .url("https://www.google.com/")
                .method("POST")
                .header("Auth", "token123")
                .build();
        System.out.println(request);
    }
}
