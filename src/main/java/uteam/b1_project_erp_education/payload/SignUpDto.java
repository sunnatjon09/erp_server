package uteam.b1_project_erp_education.payload;

public record SignUpDto(
        String login,
        String password,
        Integer roleId) {
}