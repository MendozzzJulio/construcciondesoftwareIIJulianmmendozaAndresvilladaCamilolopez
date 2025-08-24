package app.domain.model;

public class createUser {
    private final String documentId;
    private String name;
    private int age;
    private String role;
    private String username;
    private String password;
    private String state;

    public createUser(String documentId, String name, int age, String role, String username, String password, String state) {
        this.documentId = documentId;
        this.name = name;
        this.age = age;
        this.role = role;
        this.username = username;
        this.password = password;
        this.state = state;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

}
