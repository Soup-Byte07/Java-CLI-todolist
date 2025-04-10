enum mainActions {
    SHOW ,
    EXIT ;
    public String getString() {
        return this.toString().toLowerCase();
    }
}

enum taskActions {
    SHOWALL,
    SHOW,
    EDIT,
    ADD,
    DELETE,
    BACK;
    public String getString() {
        return this.toString().toLowerCase();
    }
}

public class Main {

    // Global values

    public static void main(String[] args) {
        System.out.println("Hello, World! \n");

        System.out.println(Libs.NOCHANGE);
        System.out.println("Please enter one of the following inputs!");
        for (mainActions action : mainActions.values()) {
            System.out.println(action.getString() + "," );
        }

        String action = Libs.Input.next();
        presentActions(mainActions.valueOf(action.toUpperCase()));
    }

    public static void presentActions(mainActions a) {
        switch (a) {
            case SHOW:
                System.out.println("Showing tasks: \n");
                Tasks.showTasks();
                Tasks.presentTaskActions();
                break;
            case EXIT:
                System.out.println("Exiting app");
                break;
        }
    }
}