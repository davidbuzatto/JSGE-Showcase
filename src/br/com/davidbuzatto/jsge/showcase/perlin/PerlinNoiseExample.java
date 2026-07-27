/*
 * Copyright (C) 2026 Prof. Dr. David Buzatto
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
package br.com.davidbuzatto.jsge.showcase.perlin;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;
import br.com.davidbuzatto.jsge.imgui.GuiButton;
import br.com.davidbuzatto.jsge.imgui.GuiCheckBox;
import br.com.davidbuzatto.jsge.imgui.GuiComponent;
import br.com.davidbuzatto.jsge.imgui.GuiDropdownList;
import br.com.davidbuzatto.jsge.imgui.GuiSlider;
import br.com.davidbuzatto.jsge.imgui.GuiSpinner;
import br.com.davidbuzatto.jsge.math.MathUtils;
import br.com.davidbuzatto.jsge.math.PerlinNoise;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Example of using PerlinNoise to render a procedural terrain, comparing
 * plain noise, fBm, ridge and turbulence.
 *
 * @author Prof. Dr. David Buzatto
 */
public class PerlinNoiseExample extends EngineFrame {

    private static final int MODE_NOISE = 0;
    private static final int MODE_FBM = 1;
    private static final int MODE_RIDGE = 2;
    private static final int MODE_TURBULENCE = 3;

    private static final double ANIMATION_SPEED = 0.15;

    private int cellSize;
    private int canvasWidth;
    private int canvasHeight;
    private int cols;
    private int rows;
    private int panelX;

    private double time;

    private List<GuiComponent> components;
    private GuiDropdownList modeDropdown;
    private GuiSlider scaleSlider;
    private GuiSpinner seedSpinner;
    private GuiButton randomSeedButton;
    private GuiSpinner octavesSpinner;
    private GuiSlider lacunaritySlider;
    private GuiSlider gainSlider;
    private GuiSlider offsetSlider;
    private GuiCheckBox animateCheckBox;
    private GuiCheckBox terrainColorsCheckBox;

    /**
     * Creates the example.
     */
    public PerlinNoiseExample() {
        super( 800, 600, "Perlin Noise", 60, true );
    }

    @Override
    public void create() {

        useAsDependencyForIMGUI();
        setDefaultFontSize( 20 );

        cellSize = 5;
        canvasWidth = 580;
        canvasHeight = getScreenHeight();
        cols = canvasWidth / cellSize;
        rows = canvasHeight / cellSize;
        panelX = canvasWidth + 20;

        components = new ArrayList<>();

        int y = 15;
        int controlWidth = 190;
        int vSpacing = 60;

        modeDropdown = new GuiDropdownList( panelX, y += 20, controlWidth, 28,
                List.of( "Noise", "FBM", "Ridge", "Turbulence" ) );

        y += vSpacing;
        scaleSlider = new GuiSlider( panelX, y, controlWidth, 20, 60, 10, 200 );

        y += vSpacing;
        seedSpinner = new GuiSpinner( panelX, y, 90, 28, 0, 0, 255 );
        randomSeedButton = new GuiButton( panelX + 100, y, 90, 28, "New seed" );

        y += vSpacing;
        octavesSpinner = new GuiSpinner( panelX, y, 90, 28, 5, 1, 8 );

        y += vSpacing;
        lacunaritySlider = new GuiSlider( panelX, y, controlWidth, 20, 2.0, 1.2, 3.5 );

        y += vSpacing;
        gainSlider = new GuiSlider( panelX, y, controlWidth, 20, 0.5, 0.1, 0.9 );

        y += vSpacing;
        offsetSlider = new GuiSlider( panelX, y, controlWidth, 20, 1.0, 0.3, 2.5 );

        y += vSpacing;
        animateCheckBox = new GuiCheckBox( panelX, y, controlWidth, 24, "Animate" );

        y += 32;
        terrainColorsCheckBox = new GuiCheckBox( panelX, y, controlWidth, 24, "Terrain colors" );
        terrainColorsCheckBox.setSelected( true );

        components.add( scaleSlider );
        components.add( seedSpinner );
        components.add( randomSeedButton );
        components.add( octavesSpinner );
        components.add( lacunaritySlider );
        components.add( gainSlider );
        components.add( offsetSlider );
        components.add( animateCheckBox );
        components.add( terrainColorsCheckBox );
        components.add( modeDropdown );

    }

    @Override
    public void update( double delta ) {

        int mode = modeDropdown.getSelectedItemIndex();

        seedSpinner.setVisible( mode == MODE_NOISE );
        randomSeedButton.setVisible( mode == MODE_NOISE );
        octavesSpinner.setVisible( mode != MODE_NOISE );
        lacunaritySlider.setVisible( mode != MODE_NOISE );
        gainSlider.setVisible( mode != MODE_NOISE );
        offsetSlider.setVisible( mode == MODE_RIDGE );

        for ( GuiComponent c : components ) {
            c.update( delta );
        }

        if ( randomSeedButton.isMousePressed() ) {
            seedSpinner.setValue( MathUtils.getRandomValue( 0, 255 ) );
        }

        if ( animateCheckBox.isSelected() ) {
            time += delta * ANIMATION_SPEED;
        }

    }

    @Override
    public void draw() {

        clearBackground( WHITE );

        int mode = modeDropdown.getSelectedItemIndex();
        double scale = scaleSlider.getValue();
        int seed = seedSpinner.getValue();
        int octaves = octavesSpinner.getValue();
        double lacunarity = lacunaritySlider.getValue();
        double gain = gainSlider.getValue();
        double offset = offsetSlider.getValue();
        boolean terrainColors = terrainColorsCheckBox.isSelected();

        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < cols; j++ ) {

                double nx = ( j * cellSize ) / scale;
                double ny = ( i * cellSize ) / scale;

                double height = computeHeight( mode, nx, ny, time, seed, octaves, lacunarity, gain, offset );
                Color color = terrainColors ? terrainColor( height ) : grayscaleColor( height );

                fillRectangle( j * cellSize, i * cellSize, cellSize, cellSize, color );

            }
        }

        drawRectangle( 0, 0, canvasWidth, canvasHeight, BLACK );

        fillRectangle( canvasWidth, 0, getScreenWidth() - canvasWidth, canvasHeight, ColorUtils.colorAlpha( LIGHTGRAY, 0.3 ) );

        drawText( "Mode", panelX, modeDropdown.getBounds().y - 16, 13, BLACK );
        drawText( String.format( "Scale: %.0f", scale ), panelX, scaleSlider.getBounds().y - 16, 13, BLACK );

        if ( mode == MODE_NOISE ) {
            drawText( "Seed", panelX, seedSpinner.getBounds().y - 16, 13, BLACK );
        } else {
            drawText( String.format( "Octaves: %d", octaves ), panelX, octavesSpinner.getBounds().y - 16, 13, BLACK );
            drawText( String.format( "Lacunarity: %.2f", lacunarity ), panelX, lacunaritySlider.getBounds().y - 16, 13, BLACK );
            drawText( String.format( "Gain: %.2f", gain ), panelX, gainSlider.getBounds().y - 16, 13, BLACK );
            if ( mode == MODE_RIDGE ) {
                drawText( String.format( "Offset: %.2f", offset ), panelX, offsetSlider.getBounds().y - 16, 13, BLACK );
            }
        }

        for ( GuiComponent c : components ) {
            c.draw();
        }

        drawFPS( getScreenWidth() - 80, getScreenHeight() - 20 );

    }

    private double computeHeight( int mode, double x, double y, double z, int seed, int octaves, double lacunarity, double gain, double offset ) {

        switch ( mode ) {

            case MODE_FBM: {
                double value = PerlinNoise.fbm( x, y, z, lacunarity, gain, octaves );
                return MathUtils.clamp( ( value / amplitudeSum( 1.0, gain, octaves ) + 1 ) / 2, 0, 1 );
            }

            case MODE_RIDGE: {
                double value = PerlinNoise.ridge( x, y, z, lacunarity, gain, offset, octaves );
                double maxValue = amplitudeSum( 0.5, gain, octaves ) * offset * offset;
                return MathUtils.clamp( value / maxValue, 0, 1 );
            }

            case MODE_TURBULENCE: {
                double value = PerlinNoise.turbulence( x, y, z, lacunarity, gain, octaves );
                return MathUtils.clamp( value / amplitudeSum( 1.0, gain, octaves ), 0, 1 );
            }

            default: {
                double value = PerlinNoise.noise( x, y, z, 0, 0, 0, seed );
                return MathUtils.clamp( ( value + 1 ) / 2, 0, 1 );
            }

        }

    }

    // estimates the maximum amplitude a fractal noise sum can reach, so its
    // output can be normalized back to a displayable [0, 1] range
    private double amplitudeSum( double startAmplitude, double gain, int octaves ) {

        double amplitude = startAmplitude;
        double sum = 0;

        for ( int i = 0; i < octaves; i++ ) {
            sum += amplitude;
            amplitude *= gain;
        }

        return sum;

    }

    private Color terrainColor( double height ) {

        if ( height < 0.3 ) {
            return ColorUtils.lerp( DARKBLUE, SKYBLUE, height / 0.3 );
        } else if ( height < 0.38 ) {
            return ColorUtils.lerp( SKYBLUE, BEIGE, ( height - 0.3 ) / 0.08 );
        } else if ( height < 0.55 ) {
            return ColorUtils.lerp( BEIGE, LIME, ( height - 0.38 ) / 0.17 );
        } else if ( height < 0.75 ) {
            return ColorUtils.lerp( LIME, DARKGREEN, ( height - 0.55 ) / 0.2 );
        } else if ( height < 0.9 ) {
            return ColorUtils.lerp( DARKGREEN, GRAY, ( height - 0.75 ) / 0.15 );
        } else {
            return ColorUtils.lerp( GRAY, WHITE, ( height - 0.9 ) / 0.1 );
        }

    }

    private Color grayscaleColor( double height ) {
        int gray = (int) MathUtils.clamp( height * 255, 0, 255 );
        return new Color( gray, gray, gray );
    }

    /**
     * Runs the example.
     * @param args Arguments.
     */
    public static void main( String[] args ) {
        new PerlinNoiseExample();
    }

}
