
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import controllers.AcceptController;
import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;

public class LogicTest {
    public LogicTest() {

    }

    @Test
    public void givenLogicWhenStartNewGameThenControllerIsStartController() {
        Logic logic = new Logic();

        assertThat(logic.getController(), instanceOf(StartController.class));
    }

    @Test
    public void givenLogicWhenGameIsCancelThenControllerIsResumeController() {
        Logic logic = new Logic();
        AcceptController controller = logic.getController();
        assertThat(controller, instanceOf(StartController.class));
        ((StartController)controller).start(); 

        controller = (PlayController)logic.getController();
        assertThat(controller, instanceOf(PlayController.class));
        ((PlayController)controller).cancel();

        assertThat(logic.getController(), instanceOf(ResumeController.class));
    }

    @Test
    public void givenLogicWhenResumeGameIsNoTheControllerIsNull() {
        Logic logic = new Logic();
        AcceptController controller = logic.getController();
        assertThat(controller, instanceOf(StartController.class));
        ((StartController)controller).start(); 

        controller = logic.getController();
        assertThat(controller, instanceOf(PlayController.class));
        ((PlayController)controller).cancel();
        
        controller = logic.getController();
        assertThat(controller, instanceOf(ResumeController.class));
        ((ResumeController)controller).resume(false);

        assertNull(logic.getController());
    }

    @Test
    public void givenLogicWhenResumeGameIsNoTheControllerPlayController() {
        Logic logic = new Logic();
        AcceptController controller = logic.getController();
        assertThat(controller, instanceOf(StartController.class));
        ((StartController)controller).start(); 

        controller = logic.getController();
        assertThat(controller, instanceOf(PlayController.class));
        ((PlayController)controller).cancel();
        
        controller = logic.getController();
        assertThat(controller, instanceOf(ResumeController.class));
        ((ResumeController)controller).resume(true);

        controller = logic.getController();
        assertThat(controller, instanceOf(PlayController.class));
    }
}