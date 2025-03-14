/*
 * Copyright (C) 2025 Prof. Dr. David Buzatto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.davidbuzatto.jsge.showcase.color;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;
import br.com.davidbuzatto.jsge.imgui.GuiButton;
import br.com.davidbuzatto.jsge.imgui.GuiColorPicker;
import br.com.davidbuzatto.jsge.imgui.GuiComponent;
import br.com.davidbuzatto.jsge.imgui.GuiWindow;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Exemplo de uso de alguns métodos para manipulação de cores.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ColorMethodsExample extends EngineFrame {

    private Color baseColor;
    
    private List<GuiComponent> components;
    private GuiWindow colorPickerWindow;
    private GuiColorPicker colorPicker;
    private GuiButton okButton;
    private GuiButton cancelButton;
    
    private boolean showComponents;
    private Color overlayColor = new Color( 0, 0, 0, 100 );
    
    /**
     * Cria o exemplo.
     */
    public ColorMethodsExample() {
        super( 800, 450, "Color Methods", 60, true );
    }
    
    @Override
    public void create() {
        
        baseColor = LIME;
        setDefaultFontSize( 20 );
        
        components = new ArrayList<>();
        colorPickerWindow = new GuiWindow( getScreenWidth() / 2 - 121, getScreenHeight() / 2 - 157, 242, 314, "Choose a color!", this );
        colorPicker = new GuiColorPicker( colorPickerWindow.getX() + 10, colorPickerWindow.getY() + 35, 200, 200, baseColor, this );
        cancelButton = new GuiButton( colorPickerWindow.getX() + colorPickerWindow.getWidth() - 70, colorPicker.getY() + colorPicker.getHeight() + 40, 60, 30, "Cancel", this );
        okButton = new GuiButton( cancelButton.getX() - 60, colorPicker.getY() + colorPicker.getHeight() + 40, 50, 30, "OK", this );
        
        components.add( colorPickerWindow );
        components.add( colorPicker );
        components.add( okButton );
        components.add( cancelButton );
        
    }

    @Override
    public void update( double delta ) {
        
        if ( isMouseButtonPressed( MOUSE_BUTTON_RIGHT ) ) {
            showComponents = true;
        }
        
        for ( GuiComponent c : components ) {
            c.update( delta );
        }
        
        if ( okButton.isMousePressed() ) {
            baseColor = colorPicker.getColor();
            showComponents = false;
        }
        
        if ( cancelButton.isMousePressed() ) {
            showComponents = false;
        }
        
        if ( colorPickerWindow.isCloseButtonPressed() ) {
            showComponents = false;
        }
        
    }
    
    @Override
    public void draw() {
        
        clearBackground( WHITE );
        
        int iterations = 300;
        
        double xStart = 70;
        double xEnd = getScreenWidth() - 400;
        double width = xEnd - xStart;
        
        double yStart = 30;
        double yEnd = getScreenHeight() - 10;
        double height = yEnd - yStart;
        
        for ( int i = 0; i <= iterations; i++ ) {
            fillRectangle( 
                    xStart + ( i / (double) iterations ) * width, 
                    yStart + ( i / (double) iterations ) * height, 
                    2, 2, 
                    ColorUtils.colorFromHSV( ( i / (double) iterations ) * 360.0, 1, 1 )
            );
        }
        
        fillRectangle( 10, 30, 50, 50, baseColor );
        drawText( "base", 70, 50, BLACK );
        fillRectangle( 10, 80, 50, 50, ColorUtils.colorAlpha( baseColor, 0.5 ) );
        drawText( "50% alpha", 70, 100, BLACK );
        fillRectangle( 10, 130, 50, 50, ColorUtils.colorTint( baseColor, WHITE ) );
        drawText( "white tint", 70, 150, BLACK );
        fillRectangle( 10, 180, 50, 50, ColorUtils.colorInvert( baseColor ) );
        drawText( "inverted", 70, 200, BLACK );
        fillRectangle( 10, 230, 50, 50, ColorUtils.colorGrayscale( baseColor ) );
        drawText( "grayscale", 70, 250, BLACK );
        fillRectangle( 10, 280, 50, 50, ColorUtils.colorBrightness( baseColor, -0.5 ) );
        drawText( "-0.5 brightness", 70, 300, BLACK );
        fillRectangle( 10, 330, 50, 50, ColorUtils.colorContrast( baseColor, -0.5 ) );
        drawText( "-0.5 contrast", 70, 350, BLACK );
        
        String message = "right click me ;)";
        drawText( message, 10, getScreenHeight() - 30, BLACK );
        
        drawHSVCircle();
        
        drawFPS( 10, 10 );
        
        if ( showComponents ) {
            fillRectangle( 0, 0, getScreenWidth(), getScreenHeight(), overlayColor );
            for ( GuiComponent c : components ) {
                c.draw();
            }
        }
        
    }
    
    private void drawHSVCircle() {
        
        int radius = 180;
        int bQuantity = 6;
        int step = 15;
        int x = getScreenWidth() - radius - 50; 
        int y = getScreenHeight() / 2;
        double iTurn = -97.5;
        
        for ( double r = radius; r > 0; r -= radius / bQuantity ) {
            for ( int i = 0; i < 360; i += step ) {
                fillCircleSector( x, y, r, i + iTurn, i + iTurn + step + 1, ColorUtils.colorFromHSV( i, 1, r / radius ) );
            }
        }
        
        for ( int i = 0; i < 360; i += step ) {
            double xp = x + Math.cos( Math.toRadians( i + iTurn + 7.5 ) ) * ( radius + 15 );
            double yp = y + Math.sin( Math.toRadians( i + iTurn + 7.5 ) ) * ( radius + 15 );
            String s = String.valueOf( i );
            int w = measureText( s, 16 );
            drawText( String.valueOf( i ), xp - w / 2, yp - 4, 16, BLACK );
        }
        
        drawCircle( x, y, radius, BLACK );
        
    }
    
    /**
     * Executa o exemplo.
     * @param args Argumentos.
     */
    public static void main( String[] args ) {
        new ColorMethodsExample();
    }
    
}
