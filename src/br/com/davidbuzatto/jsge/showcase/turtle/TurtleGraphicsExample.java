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
package br.com.davidbuzatto.jsge.showcase.turtle;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.image.Image;
import br.com.davidbuzatto.jsge.imgui.GuiColorPicker;
import br.com.davidbuzatto.jsge.turtle.Turtle;
import br.com.davidbuzatto.jsge.turtle.TurtleStep;

/**
 * Exemplo de Gráfico de Tartaruga (Turtle Graphics).
 * 
 * @author Prof. Dr. David Buzatto
 */
public class TurtleGraphicsExample extends EngineFrame {
    
    private Turtle turtle;
    private Image turtleImage;
    private GuiColorPicker colorPicker;
    
    /**
     * Cria o exemplo.
     */
    public TurtleGraphicsExample() {
        super( 800, 450, "Turtle Graphics", 60, true, false, false, false, false, false );
    }
    
    @Override
    public void create() {
        
        useAsDependencyForIMGUI();
        
        turtle = new Turtle( getScreenWidth() / 2, getScreenHeight() / 2 );
        turtleImage = loadImage( "resources/images/turtle.png" );
        
        colorPicker = new GuiColorPicker( 
            getScreenWidth() - 120, getScreenHeight() - 120, 80, 80, BLACK
        );
        
    }
    
    @Override
    public void update( double delta ) {
        
        double length = 10;
        double amount = 5;

        if ( isKeyPressed( KEY_UP ) ) {
            turtle.setPenColor( colorPicker.getColor() );
            turtle.forward( length );
        } else if ( isKeyPressed( KEY_DOWN ) ) {
            turtle.setPenColor( colorPicker.getColor() );
            turtle.backward(length );
        } else if ( isKeyPressed( KEY_LEFT ) ) {
            turtle.setPenColor( colorPicker.getColor() );
            turtle.left( length );
        } else if ( isKeyPressed( KEY_RIGHT ) ) {
            turtle.setPenColor( colorPicker.getColor() );
            turtle.right( length );
        } else if ( isKeyPressed( KEY_PAGE_UP ) ) {
            turtle.rotate( -amount );
        } else if ( isKeyPressed( KEY_PAGE_DOWN ) ) {
            turtle.rotate( amount );
        } else if ( isKeyPressed( KEY_EQUAL ) ) {
            turtle.increasePenWidth();
        } else if ( isKeyPressed( KEY_MINUS ) ) {
            turtle.decreasePenWidth();
        } else if ( isKeyPressed( KEY_F1 ) ) {
            turtle.togglePen();
        } else if ( isKeyPressed( KEY_S ) ) {
            turtle.saveState();
        } else if ( isKeyPressed( KEY_R ) ) {
            turtle.restoreState();
        }
        
        colorPicker.update( delta );
            
    }
    
    @Override
    public void draw() {
        
        clearBackground( WHITE );
        
        turtle.draw( this );
            
        double width = 6;
        double veWidth = 20;

        TurtleStep s = turtle.getCurrentState();

        turtleImage.draw( 
            this, 
            s.x() - turtleImage.getWidth() / 2, 
            s.y() - turtleImage.getHeight() / 2, 
            turtleImage.getWidth() / 2, 
            turtleImage.getHeight() / 2,
            s.angle() + 90
        );
        
        drawText( "Use arrows to move the turtle by 10 pixels", 10, getScreenHeight() - 105, 20, BLACK );
        drawText( "Page up and down to rotate by 5 degrees", 10, getScreenHeight() - 85, 20, BLACK );
        drawText( "F1 to toggle brush up/down", 10, getScreenHeight() - 65, 20, BLACK );
        drawText( "S to save state", 10, getScreenHeight() - 45, 20, BLACK );
        drawText( "R to restore state", 10, getScreenHeight() - 25, 20, BLACK );
        
        colorPicker.draw();
        
        drawFPS( 10, 10 );
        
    }
    
    /**
     * Executa o exemplo.
     * @param args Argumentos.
     */
    public static void main( String[] args ) {
        new TurtleGraphicsExample();
    }
    
}
