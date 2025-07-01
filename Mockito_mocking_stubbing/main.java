class Main {
    public static void main(String[] args) {
        ExternalApi mockApi = new ExternalApi() {
            @Override
            public String getData() {
                return "Mock Data"; 
            }
        };
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        if ("Mock Data".equals(result)) {
            System.out.println("Test Passed: " + result);
        } else {
            System.out.println("Test Failed: Got " + result);
        }
    }
}
interface ExternalApi {
    String getData();
}
class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api) {
        this.api = api;
    }
    public String fetchData() {
        return api.getData();
    }   }
