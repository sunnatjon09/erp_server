package uteam.b1_project_erp_education.config;

import org.springframework.core.io.ClassPathResource;

import javax.swing.*;
import java.util.Properties;

public class InitConfig {
    public static boolean isStart() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("/application.properties").getInputStream());
            if (properties.getProperty("spring.jpa.hibernate.ddl-auto").equals("update")){
                return true;
            }else{
                String confirm =JOptionPane.showInputDialog("Ma'lumotlarni o'chirib yuborishni hohlaysizmi Sunnatjon...?");
                if (confirm !=null && confirm.equals("DELETE")){
                    return true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
