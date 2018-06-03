// imports used:
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class stickfight extends javax.swing.JFrame {

    // coordinates and other such details for player 1:
    double x=150,y=250;int z=0;
    double yyy;
    double btx = x+10, bty = y+28;
    double hx = x-5, hy = y+64;
    double e1x = x+21, e1y = y+44;    //initially front
    double e2x = x-9, e2y = y+32;    //initially back
    double p1x = x+30, p1y = y+28;    //e1 initially front
    double p2x = x-16, p2y = y+46;    //e2 initially back     
    double k1x = x+10, k1y = y+68;    //initially front       hx+15    hy+4
    double k2x = x-16, k2y = y+75;    //initially back        hx-11   hy+11
    double a1x = x+14, a1y = y+91;    //k1 initially front    hx+19  hy+27
    double a2x = x-33, a2y = y+61;    //k2 initially back     hx-28 hy -3;
    double xt,btxt,hxt,e1xt,e2xt,p1xt,p2xt,k1xt,k2xt,a1xt,a2xt;    
    double yt,btyt,hyt,e1yt,e2yt,p1yt,p2yt,k1yt,k2yt,a1yt,a2yt;
   
    // coordinates and other such details for player 2:
    double x2 = 350, y2 = 250;
    double yyy2;
    double btx2 = x2+10, bty2 = y+28;
    double hx2 = x2-5, hy2 = y+64;
    double e1x2 = x2+21, e1y2 = y+44;    //initially front
    double e2x2 = x2-9, e2y2 = y+32;    //initially back
    double p1x2 = x2+30, p1y2 = y+28;    //e1 initially front
    double p2x2 = x2-16, p2y2 = y+46;    //e2 initially back     
    double k1x2 = x2+10, k1y2 = y+68;    //initially front       hx+15    hy+4
    double k2x2 = x2-16, k2y2 = y+75;    //initially back        hx-11   hy+11
    double a1x2 = x2+14, a1y2 = y+91;    //k1 initially front    hx+19  hy+27
    double a2x2 = x2-33, a2y2 = y+61;    //k2 initially back     hx-28 hy -3;
    double xt2,btxt2,hxt2,e1xt2,e2xt2,p1xt2,p2xt2,k1xt2,k2xt2,a1xt2,a2xt2;    
    double yt2,btyt2,hyt2,e1yt2,e2yt2,p1yt2,p2yt2,k1yt2,k2yt2,a1yt2,a2yt2;
    
    
    Image image;
    int score1 = 0, score2 = 0, timeleft = 61, timecheck = 0;
    frontpage obj = new frontpage();
    
    /**
     * Creates new form stickfight
     */
    public stickfight() {
        ImageIcon i = obj.i;
        image = i.getImage();
      
        initComponents();
        setSize(571,373);
    }
    
    public void paint(Graphics g) {
        g.clearRect(super.getX(),super.getY(),super.getWidth(),super.getHeight());
        g.drawImage(image,0,0,this);
        g.drawString(obj.name1,30,50);
        g.drawString("Score: "+score1,30,70);
        g.drawString(obj.name2,490,50);
        g.drawString("Score: "+score2,490,70);
        g.drawString("Time Left: "+timeleft, 250, 70);
            if(count==1){
        //face:
            g.fillOval((int)x,(int)y,25,30);  
        //body:    head to hip
            g.drawLine((int)(btx-1),(int)bty,(int)hx-1,(int)hy);       
            g.drawLine((int)btx,(int)bty,(int)hx,(int)hy);  
            g.drawLine((int)(btx+1),(int)bty,(int)(hx+1),(int)hy);
        //others:    hands and legs
            g.drawLine((int)btx-1,(int)bty,(int)e2x-1,(int)e2y);       //hand up:    shoulder to elbow 
            g.drawLine((int)btx,(int)bty,(int)e2x,(int)e2y);            
            g.drawLine((int)btx+1,(int)bty,(int)e2x+1,(int)e2y);                    
            g.drawLine((int)e2x-1,(int)e2y,(int)p2x-1,(int)p2y);       //hand down:  elbow to palm           
            g.drawLine((int)e2x,(int)e2y,(int)p2x,(int)p2y);       
            g.drawLine((int)e2x+1,(int)e2y,(int)p2x+1,(int)p2y);                  
            g.drawLine((int)btx-1,(int)bty,(int)e1x-1,(int)e1y);      //hand up:    shoulder to elbow 
            g.drawLine((int)btx,(int)bty,(int)e1x,(int)e1y);       
            g.drawLine((int)btx+1,(int)bty,(int)e1x+1,(int)e1y);       
            g.drawLine((int)e1x-1,(int)e1y,(int)p1x-1,(int)p1y);      //hand down:  elbow to palm            
            g.drawLine((int)e1x,(int)e1y,(int)p1x,(int)p1y);      
            g.drawLine((int)e1x+1,(int)e1y,(int)p1x+1,(int)p1y);                 
            g.drawLine((int)hx-1,(int)hy,(int)k1x-1,(int)k1y);       //leg up:     hip to knee 
            g.drawLine((int)hx,(int)hy,(int)k1x,(int)k1y);        
            g.drawLine((int)hx+1,(int)hy,(int)k1x+1,(int)k1y);        
            g.drawLine((int)k1x-1,(int)k1y,(int)a1x-1,(int)a1y);      //leg down:   knee to ankle
            g.drawLine((int)k1x,(int)k1y,(int)a1x,(int)a1y);      
            g.drawLine((int)k1x+1,(int)k1y,(int)a1x+1,(int)a1y);      
            g.drawLine((int)hx-1,(int)hy,(int)k2x-1,(int)k2y);       //leg up:     hip to knee
            g.drawLine((int)hx,(int)hy,(int)k2x,(int)k2y);      
            g.drawLine((int)hx+1,(int)hy,(int)k2x+1,(int)k2y);      
            g.drawLine((int)k2x-1,(int)k2y,(int)a2x-1,(int)a2y);      //leg down:   knee to ankle
            g.drawLine((int)k2x,(int)k2y,(int)a2x,(int)a2y);     
            g.drawLine((int)k2x+1,(int)k2y,(int)a2x+1,(int)a2y);    
        }  
        
        if(count==2){
        //face:
            g.fillOval((int)(yyy-x-25),(int)y,25,30); 
        //body:    head to hip
            g.drawLine((int)((yyy)-btx+1),(int)bty,(int)((yyy)-hx+1),(int)hy);       
            g.drawLine((int)((yyy)-btx),(int)bty,(int)((yyy)-hx),(int)hy);  
            g.drawLine((int)((yyy)-btx-1),(int)bty,(int)((yyy)-hx-1),(int)hy);
        //others:    hands and legs
            g.drawLine((int)(yyy-btx-1),(int)bty,(int)(yyy-e2x-1),(int)e2y);       //hand up:    shoulder to elbow     
            g.drawLine((int)(yyy-btx),(int)bty,(int)(yyy-e2x),(int)e2y);           
            g.drawLine((int)(yyy-btx+1),(int)bty,(int)(yyy-e2x+1),(int)e2y);            
            g.drawLine((int)(yyy-e2x-1),(int)e2y,(int)(yyy-p2x-1),(int)p2y);       //hand down:  elbow to palm
            g.drawLine((int)(yyy-e2x),(int)e2y,(int)(yyy-p2x),(int)p2y);     
            g.drawLine((int)(yyy-e2x+1),(int)e2y,(int)(yyy-p2x+1),(int)p2y);     
            g.drawLine((int)(yyy-btx-1),(int)bty,(int)(yyy-e1x-1),(int)e1y);      //hand up:    shoulder to elbow 
            g.drawLine((int)(yyy-btx),(int)bty,(int)(yyy-e1x),(int)e1y);     
            g.drawLine((int)(yyy-btx+1),(int)bty,(int)(yyy-e1x+1),(int)e1y);    
            g.drawLine((int)(yyy-e1x-1),(int)e1y,(int)(yyy-p1x-1),(int)p1y);      //hand down:  elbow to palm
            g.drawLine((int)(yyy-e1x),(int)e1y,(int)(yyy-p1x),(int)p1y);   
            g.drawLine((int)(yyy-e1x+1),(int)e1y,(int)(yyy-p1x+1),(int)p1y);    
            g.drawLine((int)(yyy-hx-1),(int)hy,(int)(yyy-k1x-1),(int)k1y);       //leg up:     hip to knee 
            g.drawLine((int)(yyy-hx),(int)hy,(int)(yyy-k1x),(int)k1y);      
            g.drawLine((int)(yyy-hx+1),(int)hy,(int)(yyy-k1x+1),(int)k1y);     
            g.drawLine((int)(yyy-k1x-1),(int)k1y,(int)(yyy-a1x-1),(int)a1y);      //leg down:   knee to ankle
            g.drawLine((int)(yyy-k1x),(int)k1y,(int)(yyy-a1x),(int)a1y);    
            g.drawLine((int)(yyy-k1x+1),(int)k1y,(int)(yyy-a1x+1),(int)a1y);   
            g.drawLine((int)(yyy-hx-1),(int)hy,(int)(yyy-k2x-1),(int)k2y);       //leg up:     hip to knee
            g.drawLine((int)(yyy-hx),(int)hy,(int)(yyy-k2x),(int)k2y);      
            g.drawLine((int)(yyy-hx+1),(int)hy,(int)(yyy-k2x+1),(int)k2y);     
            g.drawLine((int)(yyy-k2x-1),(int)k2y,(int)(yyy-a2x-1),(int)a2y);      //leg down:   knee to ankle
            g.drawLine((int)(yyy-k2x),(int)k2y,(int)(yyy-a2x),(int)a2y);     
            g.drawLine((int)(yyy-k2x+1),(int)k2y,(int)(yyy-a2x+1),(int)a2y);     

        }
        
        if(count==3){                                
            g.fillOval((int)xt,(int)yt,25,30);

            g.drawLine((int)btxt-1,(int)btyt,(int)hxt-1,(int)hyt);            
            g.drawLine((int)btxt,(int)btyt,(int)hxt,(int)hyt);
            g.drawLine((int)btxt+1,(int)btyt,(int)hxt+1,(int)hyt);

            g.drawLine((int)btxt-1,(int)btyt,(int)e1xt-1,(int)e1yt);             
            g.drawLine((int)btxt,(int)btyt,(int)e1xt,(int)e1yt);           
            g.drawLine((int)btxt+1,(int)btyt,(int)e1xt+1,(int)e1yt);           
          
            g.drawLine((int)btxt-1,(int)btyt,(int)e2xt-1,(int)e2yt);            
            g.drawLine((int)btxt,(int)btyt,(int)e2xt,(int)e2yt);
            g.drawLine((int)btxt+1,(int)btyt,(int)e2xt+1,(int)e2yt);

            g.drawLine((int)e1xt-1,(int)e1yt,(int)p1xt-1,(int)p1yt);    
            g.drawLine((int)e1xt,(int)e1yt,(int)p1xt,(int)p1yt);           
            g.drawLine((int)e1xt+1,(int)e1yt,(int)p1xt+1,(int)p1yt);           
       
            g.drawLine((int)e2xt-1,(int)e2yt,(int)p2xt-1,(int)p2yt);       
            g.drawLine((int)e2xt,(int)e2yt,(int)p2xt,(int)p2yt);
            g.drawLine((int)e2xt+1,(int)e2yt,(int)p2xt+1,(int)p2yt);

            g.drawLine((int)hxt-1,(int)hyt,(int)k1xt-1,(int)k1yt); 
            g.drawLine((int)hxt,(int)hyt,(int)k1xt,(int)k1yt);           
            g.drawLine((int)hxt+1,(int)hyt,(int)k1xt+1,(int)k1yt);           
          
            g.drawLine((int)hxt-1,(int)hyt,(int)k2xt-1,(int)k2yt);  
            g.drawLine((int)hxt,(int)hyt,(int)k2xt,(int)k2yt);
            g.drawLine((int)hxt+1,(int)hyt,(int)k2xt+1,(int)k2yt);

            g.drawLine((int)k1xt-1,(int)k1yt,(int)a1xt-1,(int)a1yt);  
            g.drawLine((int)k1xt,(int)k1yt,(int)a1xt,(int)a1yt);            
            g.drawLine((int)k1xt+1,(int)k1yt,(int)a1xt+1,(int)a1yt);            
          
            g.drawLine((int)k2xt-1,(int)k2yt,(int)a2xt-1,(int)a2yt);    
            g.drawLine((int)k2xt,(int)k2yt,(int)a2xt,(int)a2yt);
            g.drawLine((int)k2xt+1,(int)k2yt,(int)a2xt+1,(int)a2yt);

        }
        
        if(count==4){                
            g.fillOval((int)(yyy-xt-25),(int)yt,25,30); 

            g.drawLine((int)(yyy-btxt-1),(int)btyt,(int)(yyy-hxt-1),(int)hyt);             
            g.drawLine((int)(yyy-btxt),(int)btyt,(int)(yyy-hxt),(int)hyt);            
            g.drawLine((int)(yyy-btxt+1),(int)btyt,(int)(yyy-hxt+1),(int)hyt);            
           
            g.drawLine((int)(yyy-btxt-1),(int)btyt,(int)(yyy-e1xt-1),(int)e1yt);
            g.drawLine((int)(yyy-btxt),(int)btyt,(int)(yyy-e1xt),(int)e1yt);
            g.drawLine((int)(yyy-btxt+1),(int)btyt,(int)(yyy-e1xt+1),(int)e1yt);

            g.drawLine((int)(yyy-btxt-1),(int)btyt,(int)(yyy-e2xt-1),(int)e2yt);
            g.drawLine((int)(yyy-btxt),(int)btyt,(int)(yyy-e2xt),(int)e2yt);            
            g.drawLine((int)(yyy-btxt+1),(int)btyt,(int)(yyy-e2xt+1),(int)e2yt);            
            
            g.drawLine((int)(yyy-e1xt-1),(int)e1yt,(int)(yyy-p1xt-1),(int)p1yt);
            g.drawLine((int)(yyy-e1xt),(int)e1yt,(int)(yyy-p1xt),(int)p1yt);
            g.drawLine((int)(yyy-e1xt+1),(int)e1yt,(int)(yyy-p1xt+1),(int)p1yt);

            g.drawLine((int)(yyy-e2xt-1),(int)e2yt,(int)(yyy-p2xt-1),(int)p2yt);
            g.drawLine((int)(yyy-e2xt),(int)e2yt,(int)(yyy-p2xt),(int)p2yt);
            g.drawLine((int)(yyy-e2xt+1),(int)e2yt,(int)(yyy-p2xt+1),(int)p2yt);

            g.drawLine((int)(yyy-hxt-1),(int)hyt,(int)(yyy-k1xt-1),(int)k1yt);     
            g.drawLine((int)(yyy-hxt),(int)hyt,(int)(yyy-k1xt),(int)k1yt);
            g.drawLine((int)(yyy-hxt+1),(int)hyt,(int)(yyy-k1xt+1),(int)k1yt);

            g.drawLine((int)(yyy-hxt-1),(int)hyt,(int)(yyy-k2xt-1),(int)k2yt);  
            g.drawLine((int)(yyy-hxt),(int)hyt,(int)(yyy-k2xt),(int)k2yt);
            g.drawLine((int)(yyy-hxt+1),(int)hyt,(int)(yyy-k2xt+1),(int)k2yt);

            g.drawLine((int)(yyy-k1xt-1),(int)k1yt,(int)(yyy-a1xt-1),(int)a1yt);
            g.drawLine((int)(yyy-k1xt),(int)k1yt,(int)(yyy-a1xt),(int)a1yt);
            g.drawLine((int)(yyy-k1xt+1),(int)k1yt,(int)(yyy-a1xt+1),(int)a1yt);

            g.drawLine((int)(yyy-k2xt-1),(int)k2yt,(int)(yyy-a2xt-1),(int)a2yt);           
            g.drawLine((int)(yyy-k2xt),(int)k2yt,(int)(yyy-a2xt),(int)a2yt);
            g.drawLine((int)(yyy-k2xt+1),(int)k2yt,(int)(yyy-a2xt+1),(int)a2yt);
        }
        g.setColor(Color.BLUE);
        if(count2==1){                  
        //face:
            g.fillOval((int)x2,(int)y2,25,30);  
        //body:    head to hip
            g.drawLine((int)(btx2-1),(int)bty2,(int)hx2-1,(int)hy2);       
            g.drawLine((int)btx2,(int)bty2,(int)hx2,(int)hy2);  
            g.drawLine((int)(btx2+1),(int)bty2,(int)(hx2+1),(int)hy2);
        //others:    hands and legs
            g.drawLine((int)btx2-1,(int)bty2,(int)e2x2-1,(int)e2y2);       //hand up:    shoulder to elbow 
            g.drawLine((int)btx2,(int)bty2,(int)e2x2,(int)e2y2);            
            g.drawLine((int)btx2+1,(int)bty2,(int)e2x2+1,(int)e2y2);                    
            g.drawLine((int)e2x2-1,(int)e2y2,(int)p2x2-1,(int)p2y2);       //hand down:  elbow to palm           
            g.drawLine((int)e2x2,(int)e2y2,(int)p2x2,(int)p2y2);       
            g.drawLine((int)e2x2+1,(int)e2y2,(int)p2x2+1,(int)p2y2);                  
            g.drawLine((int)btx2-1,(int)bty2,(int)e1x2-1,(int)e1y2);      //hand up:    shoulder to elbow 
            g.drawLine((int)btx2,(int)bty2,(int)e1x2,(int)e1y2);       
            g.drawLine((int)btx2+1,(int)bty2,(int)e1x2+1,(int)e1y2);       
            g.drawLine((int)e1x2-1,(int)e1y2,(int)p1x2-1,(int)p1y2);      //hand down:  elbow to palm            
            g.drawLine((int)e1x2,(int)e1y2,(int)p1x2,(int)p1y2);      
            g.drawLine((int)e1x2+1,(int)e1y2,(int)p1x2+1,(int)p1y2);                 
            g.drawLine((int)hx2-1,(int)hy2,(int)k1x2-1,(int)k1y2);       //leg up:     hip to knee 
            g.drawLine((int)hx2,(int)hy2,(int)k1x2,(int)k1y2);        
            g.drawLine((int)hx2+1,(int)hy2,(int)k1x2+1,(int)k1y2);        
            g.drawLine((int)k1x2-1,(int)k1y2,(int)a1x2-1,(int)a1y2);      //leg down:   knee to ankle
            g.drawLine((int)k1x2,(int)k1y2,(int)a1x2,(int)a1y2);      
            g.drawLine((int)k1x2+1,(int)k1y2,(int)a1x2+1,(int)a1y2);      
            g.drawLine((int)hx2-1,(int)hy2,(int)k2x2-1,(int)k2y2);       //leg up:     hip to knee
            g.drawLine((int)hx2,(int)hy2,(int)k2x2,(int)k2y2);      
            g.drawLine((int)hx2+1,(int)hy2,(int)k2x2+1,(int)k2y2);      
            g.drawLine((int)k2x2-1,(int)k2y2,(int)a2x2-1,(int)a2y2);      //leg down:   knee to ankle
            g.drawLine((int)k2x2,(int)k2y2,(int)a2x2,(int)a2y2);     
            g.drawLine((int)k2x2+1,(int)k2y2,(int)a2x2+1,(int)a2y2);    
        }
        
        if(count2==2){            
        //face:
            g.fillOval((int)(yyy2-x2-25),(int)y2,25,30); 
        //body:    head to hip
            g.drawLine((int)((yyy2)-btx2+1),(int)bty2,(int)((yyy2)-hx2+1),(int)hy2);       
            g.drawLine((int)((yyy2)-btx2),(int)bty2,(int)((yyy2)-hx2),(int)hy2);  
            g.drawLine((int)((yyy2)-btx2-1),(int)bty2,(int)((yyy2)-hx2-1),(int)hy2);
        //others:    hands and legs
            g.drawLine((int)(yyy2-btx2-1),(int)bty2,(int)(yyy2-e2x2-1),(int)e2y2);       //hand up:    shoulder to elbow     
            g.drawLine((int)(yyy2-btx2),(int)bty2,(int)(yyy2-e2x2),(int)e2y2);           
            g.drawLine((int)(yyy2-btx2+1),(int)bty2,(int)(yyy2-e2x2+1),(int)e2y2);            
            g.drawLine((int)(yyy2-e2x2-1),(int)e2y2,(int)(yyy2-p2x2-1),(int)p2y2);       //hand down:  elbow to palm
            g.drawLine((int)(yyy2-e2x2),(int)e2y2,(int)(yyy2-p2x2),(int)p2y2);     
            g.drawLine((int)(yyy2-e2x2+1),(int)e2y2,(int)(yyy2-p2x2+1),(int)p2y2);     
            g.drawLine((int)(yyy2-btx2-1),(int)bty2,(int)(yyy2-e1x2-1),(int)e1y2);      //hand up:    shoulder to elbow 
            g.drawLine((int)(yyy2-btx2),(int)bty2,(int)(yyy2-e1x2),(int)e1y2);     
            g.drawLine((int)(yyy2-btx2+1),(int)bty2,(int)(yyy2-e1x2+1),(int)e1y2);    
            g.drawLine((int)(yyy2-e1x2-1),(int)e1y2,(int)(yyy2-p1x2-1),(int)p1y2);      //hand down:  elbow to palm
            g.drawLine((int)(yyy2-e1x2),(int)e1y2,(int)(yyy2-p1x2),(int)p1y2);   
            g.drawLine((int)(yyy2-e1x2+1),(int)e1y2,(int)(yyy2-p1x2+1),(int)p1y2);    
            g.drawLine((int)(yyy2-hx2-1),(int)hy2,(int)(yyy2-k1x2-1),(int)k1y2);       //leg up:     hip to knee 
            g.drawLine((int)(yyy2-hx2),(int)hy2,(int)(yyy2-k1x2),(int)k1y2);      
            g.drawLine((int)(yyy2-hx2+1),(int)hy2,(int)(yyy2-k1x2+1),(int)k1y2);     
            g.drawLine((int)(yyy2-k1x2-1),(int)k1y2,(int)(yyy2-a1x2-1),(int)a1y2);      //leg down:   knee to ankle
            g.drawLine((int)(yyy2-k1x2),(int)k1y2,(int)(yyy2-a1x2),(int)a1y2);    
            g.drawLine((int)(yyy2-k1x2+1),(int)k1y2,(int)(yyy2-a1x2+1),(int)a1y2);   
            g.drawLine((int)(yyy2-hx2-1),(int)hy2,(int)(yyy2-k2x2-1),(int)k2y2);       //leg up:     hip to knee
            g.drawLine((int)(yyy2-hx2),(int)hy2,(int)(yyy2-k2x2),(int)k2y2);      
            g.drawLine((int)(yyy2-hx2+1),(int)hy2,(int)(yyy2-k2x2+1),(int)k2y2);     
            g.drawLine((int)(yyy2-k2x2-1),(int)k2y2,(int)(yyy2-a2x2-1),(int)a2y2);      //leg down:   knee to ankle
            g.drawLine((int)(yyy2-k2x2),(int)k2y2,(int)(yyy2-a2x2),(int)a2y2);     
            g.drawLine((int)(yyy2-k2x2+1),(int)k2y2,(int)(yyy2-a2x2+1),(int)a2y2);     

        }
        if(count2==3){                                
            g.fillOval((int)xt2,(int)yt2,25,30);

            g.drawLine((int)btxt2-1,(int)btyt2,(int)hxt2-1,(int)hyt2);            
            g.drawLine((int)btxt2,(int)btyt2,(int)hxt2,(int)hyt2);
            g.drawLine((int)btxt2+1,(int)btyt2,(int)hxt2+1,(int)hyt2);

            g.drawLine((int)btxt2-1,(int)btyt2,(int)e1xt2-1,(int)e1yt2);             
            g.drawLine((int)btxt2,(int)btyt2,(int)e1xt2,(int)e1yt2);           
            g.drawLine((int)btxt2+1,(int)btyt2,(int)e1xt2+1,(int)e1yt2);           
          
            g.drawLine((int)btxt2-1,(int)btyt2,(int)e2xt2-1,(int)e2yt2);            
            g.drawLine((int)btxt2,(int)btyt2,(int)e2xt2,(int)e2yt2);
            g.drawLine((int)btxt2+1,(int)btyt2,(int)e2xt2+1,(int)e2yt2);

            g.drawLine((int)e1xt2-1,(int)e1yt2,(int)p1xt2-1,(int)p1yt2);    
            g.drawLine((int)e1xt2,(int)e1yt2,(int)p1xt2,(int)p1yt2);           
            g.drawLine((int)e1xt2+1,(int)e1yt2,(int)p1xt2+1,(int)p1yt2);           
       
            g.drawLine((int)e2xt2-1,(int)e2yt2,(int)p2xt2-1,(int)p2yt2);       
            g.drawLine((int)e2xt2,(int)e2yt2,(int)p2xt2,(int)p2yt2);
            g.drawLine((int)e2xt2+1,(int)e2yt2,(int)p2xt2+1,(int)p2yt2);

            g.drawLine((int)hxt2-1,(int)hyt2,(int)k1xt2-1,(int)k1yt2); 
            g.drawLine((int)hxt2,(int)hyt2,(int)k1xt2,(int)k1yt2);           
            g.drawLine((int)hxt2+1,(int)hyt2,(int)k1xt2+1,(int)k1yt2);           
          
            g.drawLine((int)hxt2-1,(int)hyt2,(int)k2xt2-1,(int)k2yt2);  
            g.drawLine((int)hxt2,(int)hyt2,(int)k2xt2,(int)k2yt2);
            g.drawLine((int)hxt2+1,(int)hyt2,(int)k2xt2+1,(int)k2yt2);

            g.drawLine((int)k1xt2-1,(int)k1yt2,(int)a1xt2-1,(int)a1yt2);  
            g.drawLine((int)k1xt2,(int)k1yt2,(int)a1xt2,(int)a1yt2);            
            g.drawLine((int)k1xt2+1,(int)k1yt2,(int)a1xt2+1,(int)a1yt2);            
          
            g.drawLine((int)k2xt2-1,(int)k2yt2,(int)a2xt2-1,(int)a2yt2);    
            g.drawLine((int)k2xt2,(int)k2yt2,(int)a2xt2,(int)a2yt2);
            g.drawLine((int)k2xt2+1,(int)k2yt2,(int)a2xt2+1,(int)a2yt2);
        }
        
        if(count2==4){                
            g.fillOval((int)(yyy2-xt2-25),(int)yt2,25,30); 

            g.drawLine((int)(yyy2-btxt2-1),(int)btyt2,(int)(yyy2-hxt2-1),(int)hyt2);             
            g.drawLine((int)(yyy2-btxt2),(int)btyt2,(int)(yyy2-hxt2),(int)hyt2);            
            g.drawLine((int)(yyy2-btxt2+1),(int)btyt2,(int)(yyy2-hxt2+1),(int)hyt2);            
           
            g.drawLine((int)(yyy2-btxt2-1),(int)btyt2,(int)(yyy2-e1xt2-1),(int)e1yt2);
            g.drawLine((int)(yyy2-btxt2),(int)btyt2,(int)(yyy2-e1xt2),(int)e1yt2);
            g.drawLine((int)(yyy2-btxt2+1),(int)btyt2,(int)(yyy2-e1xt2+1),(int)e1yt2);

            g.drawLine((int)(yyy2-btxt2-1),(int)btyt2,(int)(yyy2-e2xt2-1),(int)e2yt2);
            g.drawLine((int)(yyy2-btxt2),(int)btyt2,(int)(yyy2-e2xt2),(int)e2yt2);            
            g.drawLine((int)(yyy2-btxt2+1),(int)btyt2,(int)(yyy2-e2xt2+1),(int)e2yt2);            
            
            g.drawLine((int)(yyy2-e1xt2-1),(int)e1yt2,(int)(yyy2-p1xt2-1),(int)p1yt2);
            g.drawLine((int)(yyy2-e1xt2),(int)e1yt2,(int)(yyy2-p1xt2),(int)p1yt2);
            g.drawLine((int)(yyy2-e1xt2+1),(int)e1yt2,(int)(yyy2-p1xt2+1),(int)p1yt2);

            g.drawLine((int)(yyy2-e2xt2-1),(int)e2yt2,(int)(yyy2-p2xt2-1),(int)p2yt2);
            g.drawLine((int)(yyy2-e2xt2),(int)e2yt2,(int)(yyy2-p2xt2),(int)p2yt2);
            g.drawLine((int)(yyy2-e2xt2+1),(int)e2yt2,(int)(yyy2-p2xt2+1),(int)p2yt2);

            g.drawLine((int)(yyy2-hxt2-1),(int)hyt2,(int)(yyy2-k1xt2-1),(int)k1yt2);     
            g.drawLine((int)(yyy2-hxt2),(int)hyt2,(int)(yyy2-k1xt2),(int)k1yt2);
            g.drawLine((int)(yyy2-hxt2+1),(int)hyt2,(int)(yyy2-k1xt2+1),(int)k1yt2);

            g.drawLine((int)(yyy2-hxt2-1),(int)hyt2,(int)(yyy2-k2xt2-1),(int)k2yt2);  
            g.drawLine((int)(yyy2-hxt2),(int)hyt2,(int)(yyy2-k2xt2),(int)k2yt2);
            g.drawLine((int)(yyy2-hxt2+1),(int)hyt2,(int)(yyy2-k2xt2+1),(int)k2yt2);

            g.drawLine((int)(yyy2-k1xt2-1),(int)k1yt2,(int)(yyy2-a1xt2-1),(int)a1yt2);
            g.drawLine((int)(yyy2-k1xt2),(int)k1yt2,(int)(yyy2-a1xt2),(int)a1yt2);
            g.drawLine((int)(yyy2-k1xt2+1),(int)k1yt2,(int)(yyy2-a1xt2+1),(int)a1yt2);

            g.drawLine((int)(yyy2-k2xt2-1),(int)k2yt2,(int)(yyy2-a2xt2-1),(int)a2yt2);           
            g.drawLine((int)(yyy2-k2xt2),(int)k2yt2,(int)(yyy2-a2xt2),(int)a2yt2);
            g.drawLine((int)(yyy2-k2xt2+1),(int)k2yt2,(int)(yyy2-a2xt2+1),(int)a2yt2);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 80, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents
// methods regarding the posture and position of the players:
double co(){
    return (btx+hx);
}
double forcomp(){
    return (btx2+hx2);
}

void co2(){
    double f = co()/2;
    x = x - 2*Math.abs(yyy/2-f);
    btx = btx - 2*Math.abs(yyy/2-f);
    hx = hx - 2*Math.abs(yyy/2-f);
    e1x = e1x - 2*Math.abs(yyy/2-f);
    e2x = e2x - 2*Math.abs(yyy/2-f);
    p1x = p1x - 2*Math.abs(yyy/2-f);
    p2x = p2x - 2*Math.abs(yyy/2-f);
    k1x = k1x - 2*Math.abs(yyy/2-f);
    k2x = k2x - 2*Math.abs(yyy/2-f);
    a1x = a1x - 2*Math.abs(yyy/2-f);
    a2x = a2x - 2*Math.abs(yyy/2-f);
}
void forcomp2(){
    double f = forcomp()/2;
    x2 = x2 - 2*Math.abs(yyy2/2-f);
    btx2 = btx2 - 2*Math.abs(yyy2/2-f);
    hx2 = hx2 - 2*Math.abs(yyy2/2-f);
    e1x2 = e1x2 - 2*Math.abs(yyy2/2-f);
    e2x2 = e2x2 - 2*Math.abs(yyy2/2-f);
    p1x2 = p1x2 - 2*Math.abs(yyy2/2-f);
    p2x2 = p2x2 - 2*Math.abs(yyy2/2-f);
    k1x2 = k1x2 - 2*Math.abs(yyy2/2-f);
    k2x2 = k2x2 - 2*Math.abs(yyy2/2-f);
    a1x2 = a1x2 - 2*Math.abs(yyy2/2-f);
    a2x2 = a2x2 - 2*Math.abs(yyy2/2-f);
}
double getc(int a){
    double xxx = 0;
    if(a==1)
        xxx = btx;
    else if(a==2)
        xxx = btx2;
    else if(a==3)
        xxx = (yyy-btx);
    else if(a==4)
        xxx = (yyy2-btx2);
    return xxx;
}

double e1, p1;
void set(){
    z = (int)co()/2;        
    xt=z-Math.abs(z-btx-2);btxt=z;hxt=z-3;e1xt=z+10;p1xt=z+21;
    e2xt=z-7;p2xt=z+9;k1xt=z+4;a1xt=z+10;k2xt=z-7;a2xt=z-12;
    yt=y-3.5;btyt=bty-3;hyt=hy;e1yt=291;e2yt=293;
    p1yt=279;p2yt=280;k1yt=325;k2yt=326;a1yt=340;a2yt=341;
    e1 = Math.sqrt(Math.pow(e1xt-btxt,2)+Math.pow(e1yt-btyt,2));
    p1 = Math.sqrt(Math.pow(p1xt-e1xt,2)+Math.pow(p1yt-e1yt,2));
}

double e12,p12;
void setcomp(){
    z = (int)forcomp()/2;        
    xt2=z-Math.abs(z-btx2-2);btxt2=z;hxt2=z-3;e1xt2=z+10;p1xt2=z+21;
    e2xt2=z-7;p2xt2=z+9;k1xt2=z+4;a1xt2=z+10;k2xt2=z-7;a2xt2=z-12;
    yt2=y2-3.5;btyt2=bty2-3;hyt2=hy2;e1yt2=291;e2yt2=293;
    p1yt2=279;p2yt2=280;k1yt2=325;k2yt2=326;a1yt2=340;a2yt2=341;
    e12 = Math.sqrt(Math.pow(e1xt2-btxt2,2)+Math.pow(e1yt2-btyt2,2));
    p12 = Math.sqrt(Math.pow(p1xt2-e1xt2,2)+Math.pow(p1yt2-e1yt2,2));
}
// to score when attacked:
void attack(int a){
    if(a==1)
        score1+=10;
    if(a==2)
        score2+=10;
}
// to send the scores to database:
void score(){
    JOptionPane.showMessageDialog(null, "Game Over");
    int highscore = Math.max(score1, score2);
    String player = "";
    
    if(score1==score2){
        JOptionPane.showMessageDialog(null, "Draw");
    }
    else if(highscore==score1){
        JOptionPane.showMessageDialog(null, "Winner is "+obj.name1+" - "+score1);
        player = obj.name1;
    }
    else if(highscore==score2){
        JOptionPane.showMessageDialog(null, "Winner is "+obj.name2+" - "+score2);
        player = obj.name2;
    }

    try{
        Class.forName("java.sql.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/projectscores","root","mysql");
        Statement s = c.createStatement();
        String q;
        if(score1!=score2){
            q = "insert into stick values('"+player+"',"+highscore+");" ;
        }
        else{
            q = "insert into stick values('"+obj.name1+"',"+highscore+"),('"+obj.name2+"',"+highscore+");" ;
        }
        s.executeUpdate(q);
        String q2 = "delete from stick where score = 0;";
        s.executeUpdate(q2);
    }
    catch(Exception x){
        System.out.println(x.getMessage());
    }
    
    Scores obj = new Scores();
    obj.setVisible(true);
    super.setVisible(false);
}
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked
// some more variables regarding position and posture of players:
//for elbow:
double e1change = 0.5, e2change = 1.5, e1change2 = 0.5, e2change2 = 1.5;
double re1 = Math.sqrt(Math.pow(btx-e1x,2)+Math.pow(bty-e1y,2));
double re2 = Math.sqrt(Math.pow(btx-e2x,2)+Math.pow(bty-e2y,2));
double e1xc = e1x, e1yc = e1y, e2xc = e2x, e2yc = e2y;
double e1xc2 = e1x2, e1yc2 = e1y2, e2xc2 = e2x2, e2yc2 = e2y2;
//for palm:
double p1change = 1.85, p2change = 2.6, p1change2 = 1.85, p2change2 = 2.6;
final double rp1 = Math.sqrt(Math.pow(e1x-p1x,2)+Math.pow(e1y-p1y,2));
final double rp2 = Math.sqrt(Math.pow(e2x-p2x,2)+Math.pow(e2y-p2y,2));
final double p1xc = p1x, p2xc = p2x, p1yc = p1y, p2yc = p2y;
final double p1xc2 = p1x2, p2xc2 = p2x2, p1yc2 = p1y2, p2yc2 = p2y2;
//for knee:
double k1change = 0.35, k2change = 1.375, k1change2 = 0.35, k2change2 = 1.375;
final double rk1 = Math.sqrt(Math.pow(hx-k1x,2)+Math.pow(hy-k1y,2));
final double rk2 = Math.sqrt(Math.pow(hx-k2x,2)+Math.pow(hy-k2y,2));
final double k1xc = k1x, k1yc = k1y, k2xc = k2x, k2yc = k2y;
final double k1xc2 = k1x2, k1yc2 = k1y2, k2xc2 = k2x2, k2yc2 = k2y2;
//for ankle:
double a1change = 1.885, a2change = 1.53, a1change2 = 1.885, a2change2 = 1.53;
final double ra1 = Math.sqrt(Math.pow(k1x-a1x,2)+Math.pow(a1y-k1y,2));
final double ra2 = Math.sqrt(Math.pow(a2x-k2x,2)+Math.pow(a2y-k2y,2));
final double a1xc = a1x, a1yc = a1y, a2yc = a2y, a2xc = a2x;
final double a1xc2 = a1x2, a1yc2 = a1y2, a2yc2 = a2y2, a2xc2 = a2x2;
//others:
final double btxc = btx, btxc2 = btx2;
final double btxtc = btxt, btytc = btyt;
double reqd, reqd2;

ActionListener action,act222,act1,act2,fall1,fall2,frontfall,frontfall2,time;
Timer t,t2,pun1,pun2,f1,f2,fft,fft2,tk;
int count = 3,count2 = 4,ii=0,zz=0;
int test1 = 0,test2 = 0;
boolean felldown1 = false, felldown2 = false;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if((count==1)||(count==3)){
            reqd = getc(1);
        }
        else if((count==2)||(count==4)){
            reqd = getc(3);
        }
        if((count2==1)||(count2==3)){
            reqd2 = getc(2);
        }
        else if((count2==2)||(count2==4)){
            reqd2 = getc(4);
        }
        
        if(Math.abs(reqd-reqd2)<=42){
            if((test1==1)||(test2==0)){
                if((pc1==true)&&(pc2==true)){
                    pun2.stop();
                    pc1 = false;
                    pc2 = false;
                }
                if(ch2==1){
                    setcomp();
                    count2 = 3;
                    ch2 = 0;
                }
                if(ch2==2){
                    setcomp();
                    count2 = 4;
                    ch2 = 0;
                }
                repaint();
            }
            if((test2==1)||(test1==0)){
                if((pc1==true)&&(pc2==true)){
                    pun1.stop();
                    pc1 = false;
                    pc2 = false;
                }
                if(ch==1){
                    set();
                    count = 3;
                    ch = 0;
                }
                if(ch==2){
                    set();
                    count = 4;
                    ch = 0;
                }
                repaint();
            }
            
            if((reqd<reqd2)&&(test1==1)){
                if((count==3)&&(count2==3)){
                    frontfall2 = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown2 = true;
                            xt2+=5.7;yt2+=4.1;
                            hxt2+=3;hyt2+=1.25;
                            btxt2+=5.6;btyt2+=4;
                            e1xt2+=5.5;e1yt2+=4;
                            e2xt2+=6.3;e2yt2+=3.8;
                            p1xt2+=6;p1yt2+=5;
                            p2xt2+=6.1;p2yt2+=4.8;
                            k1xt2+=3;k1yt2+=1.3;
                            k2xt2+=3;k2yt2+=1.3;
                            a1xt2+=0.9;
                            a2xt2+=2;
                            if(k1yt2>=a1yt2){
                                fft2.stop();
                                test1 = 0;
                                test2 = 0;
                            }
                            repaint();
                        }
                    };
                    fft2 = new Timer(100,frontfall2);
                    fft2.setDelay(40);
                    fft2.setRepeats(true);
                    fft2.start();
                    attack(1);
                    repaint();
                }
                if((count==3)&&(count2==4)){
                    fall2 = new ActionListener(){
                      @Override
                      public void actionPerformed(ActionEvent e){
                          felldown2 = true;
                          a1xt2-=3;a2xt2-=0.5;
                          k1xt2-=2;k2xt2-=1;
                          hxt2-=3;hyt2+=4;
                          xt2-=5.5;yt2+=5.5;
                          btxt2-=5.5;btyt2+=5.5;
                          e2xt2-=5;e2yt2+=5;
                          e1xt2-=8;
                          e1yt2 = btyt2 + Math.sqrt(Math.pow(e12,2)-Math.pow(e1xt2-btxt2,2));
                          p1xt2-=8.5;
                          p1yt2 = e1yt2 + Math.sqrt(Math.pow(p12,2)-Math.pow(e1xt2-p1xt2,2));
                          p2xt2-=6.6;
                          p2yt2 = e2yt2 + Math.sqrt(Math.pow(p12,2)-Math.pow(p2xt2-e2xt2,2));
                          if(hyt2>=a1yt2-2){
                              f2.stop();
                              test1 = 0;
                              test2 = 0;
                          }    
                          repaint();
                      }
                    };
                    f2 = new Timer(100,fall2);
                    f2.setDelay(40);
                    f2.setRepeats(true);
                    f2.start();
                    attack(1);
                    repaint();
                }
            }

            if((reqd>reqd2)&&(test1==1)){
                if((count==4)&&(count2==3)){
                    fall2 = new ActionListener(){
                      @Override
                      public void actionPerformed(ActionEvent e){
                          felldown2 = true;
                          a1xt2-=3;a2xt2-=0.5;
                          k1xt2-=2;k2xt2-=1;
                          hxt2-=3;hyt2+=4;
                          xt2-=5.5;yt2+=5.5;
                          btxt2-=5.5;btyt2+=5.5;
                          e2xt2-=5;e2yt2+=5;
                          e1xt2-=8;
                          e1yt2 = btyt2 + Math.sqrt(Math.pow(e12,2)-Math.pow(e1xt2-btxt2,2));
                          p1xt2-=8.5;
                          p1yt2 = e1yt2 + Math.sqrt(Math.pow(p12,2)-Math.pow(e1xt2-p1xt2,2));
                          p2xt2-=6.6;
                          p2yt2 = e2yt2 + Math.sqrt(Math.pow(p12,2)-Math.pow(p2xt2-e2xt2,2));
                          if(hyt2>=a1yt2-2){
                              f2.stop();
                              test1 = 0;
                              test2 = 0;
                          }    
                          repaint();
                      }
                    };
                    f2 = new Timer(100,fall2);
                    f2.setDelay(40);
                    f2.setRepeats(true);
                    f2.start();
                    attack(1);
                    repaint();
                }    
                if((count==4)&&(count2==4)){
                    frontfall2 = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown2 = true;
                            xt2+=5.7;yt2+=4.1;
                            hxt2+=3;hyt2+=1.25;
                            btxt2+=5.6;btyt2+=4;
                            e1xt2+=5.5;e1yt2+=4;
                            e2xt2+=6.3;e2yt2+=3.8;
                            p1xt2+=6;p1yt2+=5;
                            p2xt2+=6.1;p2yt2+=4.8;
                            k1xt2+=3;k1yt2+=1.3;
                            k2xt2+=3;k2yt2+=1.3;
                            a1xt2+=0.9;
                            a2xt2+=2;
                            if(k1yt2>=a1yt2){
                                fft2.stop();
                                test1 = 0;
                                test2 = 0;
                            }
                            repaint();
                        }
                    };
                    fft2 = new Timer(100,frontfall2);
                    fft2.setDelay(40);
                    fft2.setRepeats(true);
                    fft2.start();
                    attack(1);
                    repaint();
                }
            }

            if((reqd2<reqd)&&(test2==1)){
                if((count2==3)&&(count==3)){
                    frontfall = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown1 = true;  
                            xt+=5.7;yt+=4.1;
                            hxt+=3;hyt+=1.25;
                            btxt+=5.6;btyt+=4;
                            e1xt+=5.5;e1yt+=4;
                            e2xt+=6.3;e2yt+=3.8;
                            p1xt+=6;p1yt+=5;
                            p2xt+=6.1;p2yt+=4.8;
                            k1xt+=3;k1yt+=1.3;
                            k2xt+=3;k2yt+=1.3;
                            a1xt+=0.9;
                            a2xt+=2;
                            if(k1yt>=a1yt){
                                fft.stop();
                                test2 = 0;
                                test1 = 0;
                            }
                            repaint();
                        }
                    };
                    fft = new Timer(100,frontfall);
                    fft.setDelay(40);
                    fft.setRepeats(true);
                    fft.start();   
                    attack(2);
                    repaint();
                }
                if((count2==3)&&(count==4)){
                    fall1 = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown1 = true; 
                            a1xt-=3;a2xt-=0.5;
                            k1xt-=2;k2xt-=1;
                            hxt-=3;hyt+=4;
                            xt-=5.5;yt+=5.5;
                            btxt-=5.5;btyt+=5.5;
                            e2xt-=5;e2yt+=5;
                            e1xt-=8;
                            e1yt = btyt + Math.sqrt(Math.pow(e1,2)-Math.pow(e1xt-btxt,2));
                            p1xt-=8.5;
                            p1yt = e1yt + Math.sqrt(Math.pow(p1,2)-Math.pow(e1xt-p1xt,2));
                            p2xt-=6.6;
                            p2yt = e2yt + Math.sqrt(Math.pow(p1,2)-Math.pow(p2xt-e2xt,2));
                            if(hyt>=a1yt-2){
                                f1.stop();
                                test2 = 0;
                                test1 = 0;
                            }    
                            repaint();
                        }
                    };
                    f1 = new Timer(100,fall1);
                    f1.setDelay(40);
                    f1.setRepeats(true);
                    f1.start();  
                    attack(2);
                    repaint();
                }
            }

            if((reqd2>reqd)&&(test2==1)){
                if((count2==4)&&(count==3)){
                    fall1 = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown1 = true; 
                            a1xt-=3;a2xt-=0.5;
                            k1xt-=2;k2xt-=1;
                            hxt-=3;hyt+=4;
                            xt-=5.5;yt+=5.5;
                            btxt-=5.5;btyt+=5.5;
                            e2xt-=5;e2yt+=5;
                            e1xt-=8;
                            e1yt = btyt + Math.sqrt(Math.pow(e1,2)-Math.pow(e1xt-btxt,2));
                            p1xt-=8.5;
                            p1yt = e1yt + Math.sqrt(Math.pow(p1,2)-Math.pow(e1xt-p1xt,2));
                            p2xt-=6.6;
                            p2yt = e2yt + Math.sqrt(Math.pow(p1,2)-Math.pow(p2xt-e2xt,2));
                            if(hyt>=a1yt-2){
                                f1.stop();
                                test2 = 0;
                                test1 = 0;
                            }    
                            repaint();
                        }
                    };
                    f1 = new Timer(100,fall1);
                    f1.setDelay(40);
                    f1.setRepeats(true);
                    f1.start();  
                    attack(2);
                    repaint();
                }
                if((count2==4)&&(count==4)){
                    frontfall = new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            felldown1 = true; 
                            xt+=5.7;yt+=4.1;
                            hxt+=3;hyt+=1.25;
                            btxt+=5.6;btyt+=4;
                            e1xt+=5.5;e1yt+=4;
                            e2xt+=6.3;e2yt+=3.8;
                            p1xt+=6;p1yt+=5;
                            p2xt+=6.1;p2yt+=4.8;
                            k1xt+=3;k1yt+=1.3;
                            k2xt+=3;k2yt+=1.3;
                            a1xt+=0.9;
                            a2xt+=2;
                            if(k1yt>=a1yt){
                                fft.stop();  
                                test2 = 0;
                                test1 = 0;
                            }
                            repaint();
                        }
                    };
                    fft = new Timer(100,frontfall);
                    fft.setDelay(40);
                    fft.setRepeats(true);
                    fft.start();     
                    attack(2);
                    repaint();
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
double bh = 0.5;
boolean s1,s2,pc1 = false,pc2 = false;
int check = 0, check2 = 0, cp1 = 0, cp2 = 0;
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        int kc = evt.getKeyCode();
        if((kc==evt.VK_RIGHT)||(kc==evt.VK_LEFT)){
            s1 = true;
            if(kc==evt.VK_RIGHT){
                count = 1;
                if(ii == 1){
                    co2();
                    ii = 0;
                }
            }
            if(kc==evt.VK_LEFT){ 
                count = 2;
                if(ii==0){
                    yyy = co();
                    ii=1;
                }
            }     
        }
        if(s1==true){
            act222 = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    x+=bh;btx+=bh;hx+=bh;
                //for elbow:
                    e1x-=e1change;
                    e1y = bty + Math.sqrt(Math.pow(re1,2)-Math.pow(e1x-btx,2));
                    e2x+=e2change;
                    e2y = bty + Math.sqrt(Math.pow(re2,2)-Math.pow(e2x-btx,2));
                //for knee:
                    k1x-=k1change;
                    k1y = hy + Math.sqrt(Math.pow(rk1,2)-Math.pow(k1x-hx,2));
                    k2x+=k2change;
                    k2y = hy + Math.sqrt(Math.pow(rk2,2)-Math.pow(k2x-hx,2));
                //for palm:
                    //p1
                    if(p1x>=btx+5){
                        if(e1change<0){
                            p1change = -2.025;
                        }
                        p1y+=p1change;
                        p1x = e1x + Math.sqrt(Math.pow(rp1,2)-Math.pow(e1y-p1y,2));
                    }
                    if(p1x<=btx+5){
                        p1x-=p1change;
                        p1y = e1y + Math.sqrt(Math.pow(rp1,2)-Math.pow(e1x-p1x,2));
                    }
                    //p2
                    if(p2x<=btx+8){
                        p2x+=p2change;
                        p2y = e2y + Math.sqrt(Math.pow(rp2,2)-Math.pow(p2x-e2x,2));
                    }
                    if(p2x>=btx+8){
                        if(e1change>0)
                            p2change = 1.92;
                        if(e1change<0)
                            p2change = -1.75;
                        p2y-=p2change;
                        p2x = e2x + Math.sqrt(Math.pow(rp2,2)-Math.pow(p2y-e2y,2));
                    }
                //for ankle:
                    //a1:
                    if(a1x>=hx-7){
                        if(e1change<0)
                            a1change = -2.885;
                        a1x-=a1change;
                        a1y = k1y + Math.sqrt(Math.pow(ra1,2)-Math.pow(a1x-k1x,2));
                    }
                    if(a1x<=hx-7){
                        if(e1change<0){
                            a2change = -1.7383;
                        }
                        a1y-=a1change;
                        a1x = k1x - Math.sqrt(Math.pow(ra1,2)-Math.pow(a1y-k1y,2));
                    }
                    //a2:
                    if(a2x<=hx-5){
                        a2y+=a2change;
                        a2x = k2x - Math.sqrt(Math.pow(ra2,2)-Math.pow(a2y-k2y,2));
                    }
                    if(a2x>=hx-5){
                        if(e1change>0)
                            a2change = 2.885;
                        a2x+=a2change;
                        a2y = k2y + Math.sqrt(Math.pow(ra2,2)-Math.pow(a2x-k2x,2));
                    }
                //changes for path reversion:
                    if(e1y==e2yc){
                        e1change = -1.5;
                        e2change = -0.5;
                        p1change = -2.95;
                        p2change = -1.6;
                        k1change = -1.375;
                        k2change = -0.35;
                        a1change = -1.92;
                        a2change = -1.885;
                    }
                    if((e1x>=btx+Math.abs(btxc-e1xc))&&(e1change<0)){
                        e1x = btx+Math.abs(btxc-e1xc); e1y = e1yc;
                        e2x = btx-Math.abs(btxc-e2xc); e2y = e2yc;
                        p1x = btx+Math.abs(btxc-p1xc); p1y = p1yc;
                        p2x = btx-Math.abs(btxc-p2xc); p2y = p2yc;
                        k1x = btx+Math.abs(btxc-k1xc); k1y = k1yc;
                        k2x = btx-Math.abs(btxc-k2xc); k2y = k2yc;
                        a1x = btx+Math.abs(btxc-a1xc); a1y = a1yc;
                        a2x = btx-Math.abs(btxc-a2xc); a2y = a2yc;
                        e1change = 0.5;
                        e2change = 1.5;
                        p1change = 1.85;
                        p2change = 2.6;
                        k1change = 0.35;
                        k2change = 1.375;
                        a1change = 1.885;
                        a2change = 1.53;
                    }
                }
            };
            if(check==0)
                t = new Timer(100,act222);
            t.setDelay(15);
            if(check==0){
                t.start();
                check = 1;
            }
        }
        if((kc==evt.VK_A)||(kc==evt.VK_D)){
            s2 = true;
            if(kc==evt.VK_A){
                count2 = 2;
                if(zz==0){
                    yyy2 = forcomp();
                    zz = 1;
                }
            }
            if(kc==evt.VK_D){
                count2 = 1;
                if(zz==1){
                    forcomp2();
                    zz = 0;
                }   
            }                    
        }
        if(s2==true){
            action = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    x2+=0.5;btx2+=0.5;hx2+=0.5;
                //for elbow:
                    e1x2-=e1change2;
                    e1y2 = bty + Math.sqrt(Math.pow(re1,2)-Math.pow(e1x2-btx2,2));
                    e2x2+=e2change2;
                    e2y2 = bty2 + Math.sqrt(Math.pow(re2,2)-Math.pow(e2x2-btx2,2));
                //for knee:
                    k1x2-=k1change2;
                    k1y2 = hy2 + Math.sqrt(Math.pow(rk1,2)-Math.pow(k1x2-hx2,2));
                    k2x2+=k2change2;
                    k2y2 = hy2 + Math.sqrt(Math.pow(rk2,2)-Math.pow(k2x2-hx2,2));
                //for palm:
                    //p1
                    if(p1x2>=btx2+5){
                        if(e1change2<0){
                            p1change2 = -2.025;
                        }
                        p1y2+=p1change2;
                        p1x2 = e1x2 + Math.sqrt(Math.pow(rp1,2)-Math.pow(e1y2-p1y2,2));
                    }
                    if(p1x2<=btx2+5){
                        p1x2-=p1change2;
                        p1y2 = e1y2 + Math.sqrt(Math.pow(rp1,2)-Math.pow(e1x2-p1x2,2));
                    }
                    //p2
                    if(p2x2<=btx2+8){
                        p2x2+=p2change2;
                        p2y2 = e2y2 + Math.sqrt(Math.pow(rp2,2)-Math.pow(p2x2-e2x2,2));
                    }
                    if(p2x2>=btx2+8){
                        if(e1change2>0)
                            p2change2 = 1.92;
                        if(e1change2<0)
                            p2change2 = -1.75;
                        p2y2-=p2change2;
                        p2x2 = e2x2 + Math.sqrt(Math.pow(rp2,2)-Math.pow(p2y2-e2y2,2));
                    }
                //for ankle(yet to start):
                    //a1:
                    if(a1x2>=hx2-7){
                        if(e1change2<0)
                            a1change2 = -2.885;
                        a1x2-=a1change2;
                        a1y2 = k1y2 + Math.sqrt(Math.pow(ra1,2)-Math.pow(a1x2-k1x2,2));
                    }
                    if(a1x2<=hx2-7){
                        if(e1change2<0){
                            a2change2 = -1.7383;
                        }
                        a1y2-=a1change2;
                        a1x2 = k1x2 - Math.sqrt(Math.pow(ra1,2)-Math.pow(a1y2-k1y2,2));
                    }
                    //a2:
                    if(a2x2<=hx2-5){
                        a2y2+=a2change2;
                        a2x2 = k2x2 - Math.sqrt(Math.pow(ra2,2)-Math.pow(a2y2-k2y2,2));
                    }
                    if(a2x2>=hx2-5){
                        if(e1change2>0)
                            a2change2 = 2.885;
                        a2x2+=a2change2;
                        a2y2 = k2y + Math.sqrt(Math.pow(ra2,2)-Math.pow(a2x2-k2x2,2));
                    }
                //changes for path reversion:
                    if(e1y2==e2yc2){
                        e1change2 = -1.5;
                        e2change2 = -0.5;
                        p1change2 = -2.95;
                        p2change2 = -1.6;
                        k1change2 = -1.375;
                        k2change2 = -0.35;
                        a1change2 = -1.92;
                        a2change2 = -1.885;
                    }
                    if((e1x2>=btx2+Math.abs(btxc2-e1xc2))&&(e1change2<0)){
                        e1x2 = btx2+Math.abs(btxc2-e1xc2); e1y2 = e1yc2;
                        e2x2 = btx2-Math.abs(btxc2-e2xc2); e2y2 = e2yc2;
                        p1x2 = btx2+Math.abs(btxc2-p1xc2); p1y2 = p1yc2;
                        p2x2 = btx2-Math.abs(btxc2-p2xc2); p2y2 = p2yc2;
                        k1x2 = btx2+Math.abs(btxc2-k1xc2); k1y2 = k1yc2;
                        k2x2 = btx2-Math.abs(btxc2-k2xc2); k2y2 = k2yc2;
                        a1x2 = btx2+Math.abs(btxc2-a1xc2); a1y2 = a1yc2;
                        a2x2 = btx2-Math.abs(btxc2-a2xc2); a2y2 = a2yc2;
                        e1change2 = 0.5;
                        e2change2 = 1.5;
                        p1change2 = 1.85;
                        p2change2 = 2.6;
                        k1change2 = 0.35;
                        k2change2 = 1.35;
                        a1change2 = 1.885;
                        a2change2 = 1.53;
                    }
                }
            };
            
            if(check2==0)
                t2 = new Timer(100,action);
            t2.setDelay(15);
            if(check2==0){
                t2.start();
                check2 = 1;
            }
        }
        
        if(kc==evt.VK_END){
            pc1 = true;
            if(ch==1){
                set();
                count = 3;
                repaint();
            }            
            if(ch==2){
                set();
                count = 4; 
                repaint();                
            }
            act1 = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(k1xt<=a1xt+2.5){
                        xt+=2.9;btxt+=2.9;hxt+=3;k1xt+=1.5;a2xt+=7;k2xt+=5;e1xt+=0.5;p1xt+=0.25;
                        e2xt+=7.1;
                        e2yt = btyt + Math.sqrt(Math.pow(re2,2)-Math.pow(btxt-e2xt,2));
                        p2yt+=0.1;
                        p2xt = e2xt + Math.sqrt(Math.pow(rp2,2)-Math.pow(e2xt-p2xt,2));
                    }
                    else if(k1xt>=a1xt+2.5){
                        pun1.stop();
                    }
                    repaint();
                }
            };
            if(cp1==0){
                pun1 = new Timer(100,act1);
                cp1 = 1;
            }
            pun1.setDelay(20);
            pun1.setRepeats(true);
            pun1.start();
        }
        
        if(kc == evt.VK_Z){
            pc2 = true;
            if(ch2==1){
                setcomp();
                count2 = 3;
                repaint();               
            }
            if(ch2==2){
                setcomp();
                count2 = 4;
                repaint();                
            }
            act2 = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if(k1xt2<=a1xt2+2.5){
                        xt2+=2.9;btxt2+=2.9;hxt2+=3;k1xt2+=1.5;a2xt2+=7;k2xt2+=5;e1xt2+=0.5;p1xt2+=0.25;
                        e2xt2+=7.1;
                        e2yt2 = btyt2 + Math.sqrt(Math.pow(re2,2)-Math.pow(btxt2-e2xt2,2));
                        p2yt2+=0.1;
                        p2xt2 = e2xt2 + Math.sqrt(Math.pow(rp2,2)-Math.pow(e2xt2-p2xt2,2));   
                    }
                    else if(k1xt2>=a1xt2+2.5){
                        pun2.stop();
                    }
                        repaint();
                }
            };
            if(cp2==0){
                pun2 = new Timer(100,act2);
                cp2 = 1;
            }
            pun2.setDelay(20);
            pun2.setRepeats(true);
            pun2.start();
        }
        repaint();
    }//GEN-LAST:event_jButton1KeyPressed
int ch = 0, ch2 = 0;
    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        // TODO add your handling code here:
        int kc = evt.getKeyCode();
        if(kc==evt.VK_RIGHT){
            t.stop();
            check = 0;
            set();
            ch = 1;
            s1 = false;
            felldown1 = false;
            count = 3;
        }
        if(kc==evt.VK_LEFT){
            t.stop();
            check = 0;
            set();
            ch = 2;
            felldown1 = false;
            s1 = false;
            count = 4;
        }
        if(kc==evt.VK_A){
            t2.stop();
            check2 = 0;
            setcomp();
            ch2 = 2;
            felldown2 = false;
            s2 = false;
            count2 = 4;
        }
        if(kc==evt.VK_D){
            t2.stop();
            check2 = 0;
            setcomp();
            ch2 = 1;
            felldown2 = false;
            s2 = false;
            count2 = 3;
        }
        if(kc==evt.VK_END){
            if((test2!=1)&&(felldown2==false)){
                test1 = 1;
                if(test1==1){
                    if(ch2==1){
                        setcomp();
                        count2 = 3;
                        repaint();
                    }
                    if(ch2==2){
                        setcomp();
                        count2 = 4;
                        repaint();
                    }
                }
                jButton1.doClick();
            }
        }
        if(kc==evt.VK_Z){
            if((test1!=1)&&(felldown1==false)){
                test2 = 1;
                if(test2==1){
                    if(ch==1){
                        set();
                        count = 3;
                        repaint();
                    }
                    if(ch==2){
                        set();
                        count = 4;
                        repaint();
                    }
                }
                jButton1.doClick();
            }
        }     
        
        repaint();
    }//GEN-LAST:event_jButton1KeyReleased


    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(timecheck==1){
            time = new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    timeleft--;
                    if(timeleft<1){
                        timeleft = 0;
                        timecheck++;
                        tk.stop();
                        if(timecheck==2)
                            score();
                    }
                    repaint();
                }  
            };
            tk = new Timer(100,time);
            tk.setDelay(1000);
            tk.setRepeats(true);
            tk.start();
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jButton1.setLocation(500,500);
        JOptionPane.showMessageDialog(this, "Player1, A and D to move, Z to punch"+
                "\n"+"Player2, Arrow keys to move, END key to punch");
        timecheck = 1;
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stickfight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stickfight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stickfight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stickfight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stickfight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
