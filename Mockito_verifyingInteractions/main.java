class Main {
    public static void main(String[] args) {
        ExternalApiMock mockApi = new ExternalApiMock();

        MyService service = new MyService(mockApi);
        service.fetchData();

        if (mockApi.wasGetDataCalled()) {
            System.out.println("Test Passed: getData() was called.");
        } else {
            System.out.println("Test Failed: getData() was NOT called.");
        }
    }
}

// Simulate external API interface
interface ExternalApi {
    String getData();
}

// Mock class that records interaction
class ExternalApiMock implements ExternalApi {
    private boolean getDataCalled = false;

    @Override
    public String getData() {
        getDataCalled = true;
        return "Mock Data";
    }

    public boolean wasGetDataCalled() {
        return getDataCalled;
    }
}

// Service that uses ExternalApi
class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }
}
