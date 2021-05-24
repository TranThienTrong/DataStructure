package Button;

import Button.View;

public class ViewChild extends View {
    int id;

    public ViewChild(){}

    public ViewChild(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Button.ViewChild{" +
                "id=" + id +
                "} ";
    }
}
