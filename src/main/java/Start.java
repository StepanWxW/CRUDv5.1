import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.EventControllerImpl;
import dto.EventDTO;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        final EventControllerImpl eventController = new EventControllerImpl();
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<EventDTO> eventDTOList = eventController.getAllToDTO();
        String gsonStringList = gson.toJson(eventDTOList);
        System.out.println(gsonStringList);
    }
}
