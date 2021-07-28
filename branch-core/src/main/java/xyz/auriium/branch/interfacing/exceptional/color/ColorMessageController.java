package xyz.auriium.branch.interfacing.exceptional.color;

import java.awt.*;

public interface ColorMessageController {

    String parse(ColorMessage message);
    void setColor(int index, Color color);

}
