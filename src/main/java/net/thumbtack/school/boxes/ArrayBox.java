package net.thumbtack.school.boxes;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T content[];
    private T element[];

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int i) {
        return element[i];
    }

    public void setElement(T element, int i) {
        this.element[i] = element;
    }

    public ArrayBox(T[] content) {
        this.content = content;
    }


    public boolean isSameSize(ArrayBox arrayBox) {
        return content.length == arrayBox.content.length;
    }
}
