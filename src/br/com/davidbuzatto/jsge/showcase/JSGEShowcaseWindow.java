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
package br.com.davidbuzatto.jsge.showcase;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.image.Image;
import br.com.davidbuzatto.jsge.showcase.animation.AnimationsExample;
import br.com.davidbuzatto.jsge.showcase.ball.BouncingBallExample;
import br.com.davidbuzatto.jsge.showcase.camera.CameraExample;
import br.com.davidbuzatto.jsge.showcase.collision.CollisionDetectionExample;
import br.com.davidbuzatto.jsge.showcase.color.ColorMethodsExample;
import br.com.davidbuzatto.jsge.showcase.curve.CurveSmoothingExample;
import br.com.davidbuzatto.jsge.showcase.image.ImageLoadingProcessingExample;
import br.com.davidbuzatto.jsge.showcase.imgui.IMGUIExample;
import br.com.davidbuzatto.jsge.showcase.painting.PaintingCapabilitiesExample;
import br.com.davidbuzatto.jsge.showcase.particles.ParticlesExample;
import br.com.davidbuzatto.jsge.showcase.primitives.methods.DrawingWithPrimitiveMethodsExample;
import br.com.davidbuzatto.jsge.showcase.primitives.objects.DrawingWithPrimitiveObjectsExample;
import br.com.davidbuzatto.jsge.showcase.scissor.ScissorExample;
import br.com.davidbuzatto.jsge.showcase.sound.SoundAndMusicExample;
import br.com.davidbuzatto.jsge.showcase.userinteraction.UserInteractionExample;
import br.com.davidbuzatto.jsge.showcase.userinteraction.gamepad.GamepadsExample;



/**
 * Janela do showcase (vitrine) da JSGE.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class JSGEShowcaseWindow extends javax.swing.JFrame {
    
    private Image logoImage;
    
    /**
     * Creates new form JSGEShowcaseFrame
     */
    public JSGEShowcaseWindow() {
        logoImage = DrawingUtils.createLogo();
        initComponents();
        setTitle( String.format( "JSGE Showcase - %s", CoreUtils.getVersion() ) );
        setIconImage( logoImage.buffImage );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        btnDrawingPrimitiveMethods = new javax.swing.JButton();
        btnDrawingPrimitiveObjects = new javax.swing.JButton();
        btnPaintingCapabilities = new javax.swing.JButton();
        btnCollisionDetection = new javax.swing.JButton();
        btnCurveSmoothing = new javax.swing.JButton();
        btnImageLoadingAndProcessing = new javax.swing.JButton();
        btnUserInteraction = new javax.swing.JButton();
        btnIMGUI = new javax.swing.JButton();
        btnColorMethods = new javax.swing.JButton();
        btnBouncingBall = new javax.swing.JButton();
        btnParticles = new javax.swing.JButton();
        btnCamera = new javax.swing.JButton();
        btnScissor = new javax.swing.JButton();
        btnSoundAndMusic = new javax.swing.JButton();
        btnAnimations = new javax.swing.JButton();
        btnGamepads = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblHeader.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("JSGE Showcase - Prof. Dr. David Buzatto");

        btnDrawingPrimitiveMethods.setText("Drawing with Primitive Methods");
        btnDrawingPrimitiveMethods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawingPrimitiveMethodsActionPerformed(evt);
            }
        });

        btnDrawingPrimitiveObjects.setText("Drawing with Primitive Objects");
        btnDrawingPrimitiveObjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawingPrimitiveObjectsActionPerformed(evt);
            }
        });

        btnPaintingCapabilities.setText("Painting Capabilities");
        btnPaintingCapabilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaintingCapabilitiesActionPerformed(evt);
            }
        });

        btnCollisionDetection.setText("Collision Detection, Points at Lines and Curves and AABBQuadtree");
        btnCollisionDetection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollisionDetectionActionPerformed(evt);
            }
        });

        btnCurveSmoothing.setText("Curve Smoothing");
        btnCurveSmoothing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurveSmoothingActionPerformed(evt);
            }
        });

        btnImageLoadingAndProcessing.setText("Image Loading and Processing");
        btnImageLoadingAndProcessing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageLoadingAndProcessingActionPerformed(evt);
            }
        });

        btnUserInteraction.setText("User Interaction");
        btnUserInteraction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserInteractionActionPerformed(evt);
            }
        });

        btnIMGUI.setText("Immediate Mode Graphical User Interface (IMGUI)");
        btnIMGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIMGUIActionPerformed(evt);
            }
        });

        btnColorMethods.setText("Color Methods");
        btnColorMethods.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorMethodsActionPerformed(evt);
            }
        });

        btnBouncingBall.setText("Bouncing Ball");
        btnBouncingBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBouncingBallActionPerformed(evt);
            }
        });

        btnParticles.setText("Particles");
        btnParticles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticlesActionPerformed(evt);
            }
        });

        btnCamera.setText("Camera");
        btnCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCameraActionPerformed(evt);
            }
        });

        btnScissor.setText("Scissor");
        btnScissor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScissorActionPerformed(evt);
            }
        });

        btnSoundAndMusic.setText("Sound and Music");
        btnSoundAndMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoundAndMusicActionPerformed(evt);
            }
        });

        btnAnimations.setText("Animations");
        btnAnimations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnimationsActionPerformed(evt);
            }
        });

        btnGamepads.setText("Gamepads");
        btnGamepads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGamepadsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDrawingPrimitiveMethods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDrawingPrimitiveObjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCollisionDetection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImageLoadingAndProcessing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUserInteraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnColorMethods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBouncingBall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParticles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(btnCamera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSoundAndMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPaintingCapabilities, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnimations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGamepads, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCurveSmoothing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnScissor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIMGUI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDrawingPrimitiveMethods)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDrawingPrimitiveObjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaintingCapabilities)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCollisionDetection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCurveSmoothing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImageLoadingAndProcessing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUserInteraction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIMGUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnColorMethods)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBouncingBall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnParticles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCamera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScissor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSoundAndMusic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnimations)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGamepads)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDrawingPrimitiveMethodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawingPrimitiveMethodsActionPerformed
        initExample( new DrawingWithPrimitiveMethodsExample() );
    }//GEN-LAST:event_btnDrawingPrimitiveMethodsActionPerformed

    private void btnDrawingPrimitiveObjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawingPrimitiveObjectsActionPerformed
        initExample( new DrawingWithPrimitiveObjectsExample() );
    }//GEN-LAST:event_btnDrawingPrimitiveObjectsActionPerformed

    private void btnCollisionDetectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollisionDetectionActionPerformed
        initExample( new CollisionDetectionExample() );
    }//GEN-LAST:event_btnCollisionDetectionActionPerformed

    private void btnImageLoadingAndProcessingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageLoadingAndProcessingActionPerformed
        initExample( new ImageLoadingProcessingExample() );
    }//GEN-LAST:event_btnImageLoadingAndProcessingActionPerformed

    private void btnUserInteractionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserInteractionActionPerformed
        initExample( new UserInteractionExample() );
    }//GEN-LAST:event_btnUserInteractionActionPerformed

    private void btnColorMethodsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorMethodsActionPerformed
        initExample( new ColorMethodsExample() );
    }//GEN-LAST:event_btnColorMethodsActionPerformed

    private void btnBouncingBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBouncingBallActionPerformed
        initExample( new BouncingBallExample() );
    }//GEN-LAST:event_btnBouncingBallActionPerformed

    private void btnParticlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticlesActionPerformed
        initExample( new ParticlesExample() );
    }//GEN-LAST:event_btnParticlesActionPerformed

    private void btnCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCameraActionPerformed
        initExample( new CameraExample() );
    }//GEN-LAST:event_btnCameraActionPerformed

    private void btnSoundAndMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoundAndMusicActionPerformed
        initExample( new SoundAndMusicExample() );
    }//GEN-LAST:event_btnSoundAndMusicActionPerformed

    private void btnPaintingCapabilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaintingCapabilitiesActionPerformed
        initExample( new PaintingCapabilitiesExample() );
    }//GEN-LAST:event_btnPaintingCapabilitiesActionPerformed

    private void btnAnimationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnimationsActionPerformed
        initExample( new AnimationsExample() );
    }//GEN-LAST:event_btnAnimationsActionPerformed

    private void btnGamepadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGamepadsActionPerformed
        initExample( new GamepadsExample() );
    }//GEN-LAST:event_btnGamepadsActionPerformed

    private void btnCurveSmoothingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurveSmoothingActionPerformed
        initExample( new CurveSmoothingExample() );
    }//GEN-LAST:event_btnCurveSmoothingActionPerformed

    private void btnScissorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScissorActionPerformed
        initExample( new ScissorExample() );
    }//GEN-LAST:event_btnScissorActionPerformed

    private void btnIMGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMGUIActionPerformed
        initExample( new IMGUIExample() );
    }//GEN-LAST:event_btnIMGUIActionPerformed

    private void initExample( EngineFrame example ) {
        example.setIconImage( logoImage.buffImage );
        example.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }
    
    /**
     * Executa o Showcase.
     * 
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;
                }
            }
        } catch ( ClassNotFoundException ex ) {
            java.util.logging.Logger.getLogger(JSGEShowcaseWindow.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger(JSGEShowcaseWindow.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger(JSGEShowcaseWindow.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger(JSGEShowcaseWindow.class.getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSGEShowcaseWindow().setVisible( true );
            }
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnimations;
    private javax.swing.JButton btnBouncingBall;
    private javax.swing.JButton btnCamera;
    private javax.swing.JButton btnCollisionDetection;
    private javax.swing.JButton btnColorMethods;
    private javax.swing.JButton btnCurveSmoothing;
    private javax.swing.JButton btnDrawingPrimitiveMethods;
    private javax.swing.JButton btnDrawingPrimitiveObjects;
    private javax.swing.JButton btnGamepads;
    private javax.swing.JButton btnIMGUI;
    private javax.swing.JButton btnImageLoadingAndProcessing;
    private javax.swing.JButton btnPaintingCapabilities;
    private javax.swing.JButton btnParticles;
    private javax.swing.JButton btnScissor;
    private javax.swing.JButton btnSoundAndMusic;
    private javax.swing.JButton btnUserInteraction;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
