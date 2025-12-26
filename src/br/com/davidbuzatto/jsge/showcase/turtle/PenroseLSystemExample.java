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
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;
import br.com.davidbuzatto.jsge.math.MathUtils;
import br.com.davidbuzatto.jsge.turtle.Turtle;

/**
 * Exemplo de Gráfico de Tartaruga para desenhar um L-System que gera padrões
 * de Penrose.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class PenroseLSystemExample extends EngineFrame {
    
    private static final int MAX_GENERATIONS = 6;
    private static final int STEPS_STEP = 12;
    private static final double DRAW_LENGTH = 650;
    
    private Turtle turtle;
    
    private int generations;
    private int steps = 1;
    
    /**
     * Cria o exemplo.
     */
    public PenroseLSystemExample() {
        super( 800, 450, "Penrose L-System", 60, true, false, false, false, false, false );
    }
    
    @Override
    public void create() {
        generations = 1;
        turtle = createPenroseTurtle( DRAW_LENGTH, generations, 5 );
    }
    
    @Override
    public void update( double delta ) {
        
        if ( isKeyPressed( KEY_UP ) ) {
            if ( generations < MAX_GENERATIONS ) {
                steps = 1;
                generations++;
                turtle = createPenroseTurtle( DRAW_LENGTH, generations, MAX_GENERATIONS );
            }
        } else if ( isKeyPressed( KEY_DOWN ) ) {
            if ( generations > 1 ) {
                steps = 1;
                generations--;
                turtle = createPenroseTurtle( DRAW_LENGTH, generations, MAX_GENERATIONS );
            }
        }
        
        steps = MathUtils.clamp( steps + STEPS_STEP, 1, turtle.getFrameCount() );
        
    }
    
    @Override
    public void draw() {
        clearBackground( WHITE );
        turtle.draw( steps, this );
        drawText( "Use up and down arrows to change generations" , 10, getScreenHeight() - 25, 20, BLACK );
        drawFPS( 10, 10 );
    }
    
    private class PenroseLSystem {
        String production;
        String ruleW;
        String ruleX;
        String ruleY;
        String ruleZ;
        double drawLength;
        double theta;
    }
    
    private PenroseLSystem createPenroseLSystem( double drawLength ) {
        
        PenroseLSystem ls = new PenroseLSystem();
        ls.production = "[X]++[X]++[X]++[X]++[X]";
        ls.ruleW = "YF++ZF4-XF[-YF4-WF]++";
        ls.ruleX = "+YF--ZF[3-WF--XF]+";
        ls.ruleY = "-WF++XF[+++YF++ZF]-";
        ls.ruleZ = "--YF++++WF[+ZF++++XF]--XF";
        ls.drawLength = drawLength;
        ls.theta = 36;

        return ls;
        
    }
    
    private void buildProductionStep( PenroseLSystem ls ) {
        
        String newProduction = "";
        
        for ( int i = 0; i < ls.production.length(); i++ ) {
            char step = ls.production.charAt( i );
            switch ( step ) {
                case 'W': newProduction += ls.ruleW; break;
                case 'X': newProduction += ls.ruleX; break;
                case 'Y': newProduction += ls.ruleY; break;
                case 'Z': newProduction += ls.ruleZ; break;
                default:
                    if ( step != 'F' ) {
                        newProduction += step;
                    }
                    break;
            }
        }
        
        ls.drawLength *= 0.5;
        ls.production = newProduction;
        
    }
    
    private Turtle createPenroseTurtle( double drawLength, int generations, int maxGenerations ) {
        
        PenroseLSystem ls = createPenroseLSystem( drawLength * ( generations / (double) maxGenerations ) );
        
        for ( int i = 0; i < generations; i++ ) {
            buildProductionStep( ls );
        }
        
        Turtle t = new Turtle( getScreenWidth() / 2, getScreenHeight() / 2 );
        t.setBrushPaint( ColorUtils.fade( BLACK, 0 ) );
        t.setBrushWidth( 2 );
        
        int repeats = 1;
        
        for ( int i = 0; i < ls.production.length(); i++ ) {
            char step = ls.production.charAt( i );
            switch ( step ) {
                case 'F':
                    for ( int j = 0; j < repeats; j++ ) {
                        t.setBrushPaint( ColorUtils.fade( BLACK, 0.2 ) );
                        /*t.setBrushPaint( 
                            ColorUtils.fade( 
                                ColorUtils.colorFromHSV( t.getCurrentState().angle(), 1, 1 ), 0.2
                            )
                        );*/
                        t.moveForward( ls.drawLength );
                    }
                    repeats = 1;
                    break;
                case '+':
                    for ( int j = 0; j < repeats; j++ ) {
                        t.rotate( ls.theta );
                    }
                    repeats = 1;
                    break;
                case '-':
                    for ( int j = 0; j < repeats; j++ ) {
                        t.rotate( -ls.theta );
                    }
                    repeats = 1;
                    break;
                case '[':
                    t.save();
                    break;
                case ']':
                    t.restoreNotPurge();
                    break;
                default:
                    if ( ( step >= 48 ) && ( step <= 57 ) ){
                        repeats = (int) step - 48;
                    }
                    break;
            }
        }
        
        return t;
        
    }
    
    /**
     * Executa o exemplo.
     * @param args Argumentos.
     */
    public static void main( String[] args ) {
        new PenroseLSystemExample();
    }
    
}
