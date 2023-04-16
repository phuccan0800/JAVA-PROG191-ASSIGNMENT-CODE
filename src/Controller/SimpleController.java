package Controller;

import java.io.IOException;

public interface SimpleController {
    void EditInformation();
    void AddInformation( String Information) throws IOException;
    void DeleteInformation(int line);
}
