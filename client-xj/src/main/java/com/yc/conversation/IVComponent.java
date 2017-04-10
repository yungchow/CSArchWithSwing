package com.yc.conversation;

import java.awt.Color;

public interface IVComponent {
	public void setColor(Color fgColor,Color bgColor);
	public void setHeaderColor(Color fgColor,Color bgColor);
	public void setSelectionColor(Color fgColor,Color bgColor);
	public void setHighlightColor(Color fgColor,Color bgColor);
	public void setContainerColor(Color color);
}
