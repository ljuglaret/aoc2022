package j9;

import java.io.*;
import java.util.*;

public class J9 {
    public List<Deplacement> lecture (String fileName) throws IOException{
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        List<Deplacement> l = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while((line = br.readLine()) != null){
              l.add(new Deplacement ( line.split(" ")[0].charAt(0), Integer.valueOf(line.split(" ")[1])));
            }
        }
        return l ;
    }


    public boolean sontVoisins(Position tete , Position queue){
       
        return (
            (Math.abs(queue.getJ() - tete.getJ())==1) && tete.getI() == queue.getI() )||
            (Math.abs(queue.getI() - tete.getI())==1) && (Math.abs(queue.getJ() - tete.getJ())==1) ||
            (Math.abs(queue.getI() - tete.getI())==1) && queue.getJ() == tete.getJ()      ;
                 
    }
    public Position rejoint( Position tete,Deplacement d){
        if(d.estBas()){
           return new Position(tete.getI()+1,tete.getJ());
        }
        else if(d.estHaut()){
            return new Position(tete.getI()-1,tete.getJ());

        }
        else if(d.estGauche()){
            return new Position(tete.getI(),tete.getJ()+1);

        }
        else if(d.estDroite()){
            return new Position(tete.getI(),tete.getJ()-1);

        }
        else {return null;}
    }

    public ArrayList<Position> rejPositions(Deplacement d,Position posInitiale, Position posARejoindre){
        ArrayList<Position> poss = new ArrayList<>();
        if(d.estBas()){
            for (int i = posInitiale.getI() -1 ; i >posARejoindre.getI() ; i--){
                poss.add(new Position(i, posARejoindre.getJ()));
            }
         }
         else if(d.estHaut()){
            for (int i = posInitiale.getI() +1; i < posARejoindre.getI() ; i++){
                poss.add(new Position(i, posARejoindre.getJ()));
            }
         }
         else if(d.estGauche()){
            for (int j = posInitiale.getJ() -1; j >posARejoindre.getJ() ; j--){
                poss.add(new Position(posARejoindre.getI(), j));
            }
           
         }
         else if(d.estDroite()){
           for (int j = posInitiale.getJ() +1; j < posARejoindre.getJ() ; j++){
                poss.add(new Position(posARejoindre.getI(),j));
            }
         }
      
         else {return null;}
        return poss;
    }
    public void p2(List<Deplacement> deplacements){
        Position tete = new Position (0, 0);
        int teteI = tete.getI();
        int teteJ = tete.getJ();
        Position queue = new Position(0,0);
        int queueI = queue.getI();
        int queueJ = queue.getJ();
        queue.setI(queueI);
        queue.setJ(queueJ);

        HashSet<Position> positionsParcouruesParLaQueue = new HashSet<>();
        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));
        for (Deplacement dep : deplacements){
           // System.out.println(dep.getSens()+ " " + dep.getValeur() );
            
            int nbDePas = dep.getValeur();
            if (teteI == queueI && dep.estDroite() ){                
                for (int i = 0 ; i < nbDePas ;i++){  
                      if( queueJ<teteJ){
                        queueJ++;
                        queue.setJ(queueJ);
                        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));
                    }
                    teteJ++;
                    tete.setJ(teteJ);
                }
            }
            else if (teteI == queueI && dep.estGauche() ){
                for (int i = 0 ; i < nbDePas ;i++){
                    if(queue.getJ()>teteJ){
                        queueJ--;
                        queue.setJ(queueJ);
                        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                    }
                    teteJ--;
                    tete.setJ(teteJ);
                }
            }
            else if (teteJ == queueJ && dep.estHaut()){
                for (int i = 0 ; i < nbDePas ;i++){
                    if(queue.getI()<teteJ){
                        queueI++;
                        queue.setI(queueI);
                        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                    }
                    teteI++;
                    tete.setI(teteI);
                }
            }
            else if (teteJ == queueJ && dep.estBas()){
                for (int i = 0 ; i < nbDePas ;i++){
                    if(queue.getI()>teteJ){
                        queueI--;
                        queue.setI(queueI);
                        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                    }
                    teteI--;
                    tete.setI(teteI);
                }
            }
            else if (dep.estBas()){
                while(nbDePas>0){
                    teteI--;
                    tete.setI(teteI);
                    nbDePas--;
                }
                if(!sontVoisins(new Position(teteI, teteJ), new Position(queueI, queueJ))){
                    ArrayList<Position> pos = rejPositions(dep,queue,tete);
                    for (Position p : pos){
                        queueI = p.getI();
                        queueJ = p.getJ();
                        queue.setI(queueI);
                        queue.setJ(queueJ);
                        positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                    }
                }
               
            }    
               else if(dep.estHaut()){
                    while(nbDePas>0){
                        teteI++;
                        tete.setI(teteI);
                        nbDePas--;         
                    }
                    if(!sontVoisins(new Position(teteI, teteJ), new Position(queueI, queueJ))){
                        ArrayList<Position> pos = rejPositions(dep,queue,tete);
                        for (Position p : pos){
                            queueI = p.getI();
                            queueJ = p.getJ();
                            queue.setI(queueI);
                            queue.setJ(queueJ);
                            positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));
                        }
                    }
                }
                else if(dep.estGauche()){
                    while(nbDePas>0){
                        teteJ--;
                        tete.setJ(teteJ);    
                        nbDePas--;    
                    }
                    
                    if(!sontVoisins(new Position(teteI, teteJ), new Position(queueI, queueJ))){
                        ArrayList<Position> pos = rejPositions(dep,queue,tete);
                        for (Position p : pos){
                            queueI = p.getI();
                            queueJ = p.getJ();
                            queue.setI(queueI);
                            queue.setJ(queueJ);
                            positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                        }
                    }
                }
                else if(dep.estDroite()){
                    while(nbDePas>0){
                        teteJ++;
                        tete.setJ(teteJ);    
                        nbDePas--;    
                    }
                    
                    if(!sontVoisins(new Position(teteI, teteJ), new Position(queueI, queueJ))){
                        ArrayList<Position> pos = rejPositions(dep,queue,tete);
                        for (Position p : pos){
                            queueI = p.getI();
                            queueJ = p.getJ();
                            queue.setI(queueI);
                            queue.setJ(queueJ);
                            positionsParcouruesParLaQueue.add(new Position(queueI, queueJ));

                        }
                    }                

                }
                ArrayList<Position> al = new ArrayList<Position>(positionsParcouruesParLaQueue);
               al.sort((Position f1,Position f2) -> f1.compareTo(f2));
        //       System.out.println(aff(positionsParcouruesParLaQueue));       
         // System.out.println(positionsParcouruesParLaQueue.toString());  
            //System.out.println("tete " + tete.getI() + "-"+ tete.getJ() + " ; queue" + queue.getI() + "-" + queue.getJ());
          
        }
        
        System.out.println(positionsParcouruesParLaQueue.size());
        for(int i = 4 ; i >=0 ; i--){
            for (int j = 0 ; j < 6 ; j++){
                if(positionsParcouruesParLaQueue.contains(new Position(i,j))){
                    System.out.print('#');
                }
                else{
                    System.out.print('.');
                }
            }
            System.out.println();
            
        }
    }
    public String aff(HashSet<Position> poss){
        String str ="";
        for (Position p : poss){
            str+=p.toString()+ ";";
        }
        return str;
    }

        
}

//6259
//6136
//5994
//2931
//6000