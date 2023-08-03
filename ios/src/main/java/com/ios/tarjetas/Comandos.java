package com.ios.tarjetas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ios.tarjetas.entities.Area;
import com.ios.tarjetas.entities.Linea;
import com.ios.tarjetas.services.AreaDAO;
import com.ios.tarjetas.services.ColaboradorDAO;
import com.ios.tarjetas.services.ComponenteDAO;
import com.ios.tarjetas.services.LineaDAO;
import com.ios.tarjetas.services.MaquinaDAO;
import com.ios.tarjetas.services.TarjetaDAO;

@Component
public class Comandos implements CommandLineRunner{
	
	@Autowired
	private ColaboradorDAO colaboradorDAO;
	
	@Autowired
	private MaquinaDAO maquinaDAO;
	
	@Autowired
	private ComponenteDAO componenteDAO;
	
	@Autowired
	private LineaDAO lineDAO;
	
	@Autowired
	private TarjetaDAO tarjetDAO;
	
	@Autowired
	private AreaDAO areaDAO;

	@Override
	public void run(String... args) throws Exception {
	/*
		Area areaCho = new Area(null, "Chocolates");
		Area areaConf = new Area(null, "Confiteria");
		Area areaAgl = new Area(null, "Aglomerados");
		
		areaDAO.guardar(areaAgl);
		areaDAO.guardar(areaCho);
		areaDAO.guardar(areaConf);
		
		Area areaChoR =areaDAO.buscarPorID(2).get();
		Area areaConfR =areaDAO.buscarPorID(3).get();
		Area areaAglR =areaDAO.buscarPorID(1).get();
		
		System.out.print(areaDAO.buscarPorID(1).get().toString());
		
		Linea lineaBind= new Linea(null, "Bindler");
		Linea lMesP = new Linea(null, "Mespack");
		Linea lDoyPAck = new Linea(null, "Doypack");
		Linea lTorre=new Linea(null, "Torre");
		Linea lBauer=new Linea(null, "Bauer");
		Linea lJensen=new Linea(null, "Jensen");
		Linea lConf=new Linea(null, "Confiteria");
		Linea lNal= new Linea(null, "Nalbach");
		Linea lSchm= new Linea(null,"Schmuk");
		Linea lWaffer= new Linea(null, "Waffer");
		Linea lKeep=new Linea(null, "Keepack");
		
		
		List<Linea>listLienas= new ArrayList<>();
		listLienas.add(lKeep);
		listLienas.add(lWaffer);
		listLienas.add(lJensen);
		listLienas.add(lBauer);
		listLienas.add(lTorre);
		listLienas.add(lMesP);
		listLienas.add(lineaBind);
		listLienas.add(lSchm);
		listLienas.add(lNal);
		listLienas.add(lConf);
		listLienas.add(lDoyPAck);
		for (Linea linea : listLienas) {
			lineDAO.guardar(linea);
		}
		List<Linea>listAux;
		List<Linea> lisLinAglom=new ArrayList<>();
		List<Linea> lisLinCH=new ArrayList<>();
		List<Linea> lisLinCon=new ArrayList<>();
		
		listAux=(List<Linea>) lineDAO.buscarTodos();
		
		for (Linea linea : listAux) {
			if(linea.getNombre().equals("Mespack")|| linea.getNombre().equals("Torre")||linea.getNombre().equals("Schmuk")||linea.getNombre().equals("Nalbach")||linea.getNombre().equals("Doypack")) {
				lisLinAglom.add(linea);}
			else if(linea.getNombre().equals("Bindler")|| linea.getNombre().equals("Bauer")||linea.getNombre().equals("Jensen")||linea.getNombre().equals("Keepack")) {
				lisLinCH.add(linea);
			}else {
				lisLinCon.add(linea);
			}
		}
	
		Set<Linea>setAg= new HashSet<Linea>(lisLinAglom);
		Set<Linea>setCH= new HashSet<Linea>(lisLinCH);
		Set<Linea>setCon= new HashSet<Linea>(lisLinCon);
		
		//areaDAO.asociarLineaAArea(lineDAO.buscarPorID(1).get(), areaChoR);
		
		Linea kep=lineDAO.buscarPorID(1).get();
		lineDAO.asociarAreaALineas(kep, areaChoR);
		
		setCH.forEach(System.out::println);
		areaDAO.guardar(areaAglR);
		areaDAO.guardar(areaConfR);
		areaDAO.guardar(areaChoR);
		
		
		Area areaChoR =areaDAO.buscarPorID(2).get();
		Area areaConfR =areaDAO.buscarPorID(3).get();
		Area areaAglR =areaDAO.buscarPorID(1).get();
		Linea weff=lineDAO.buscarPorID(1).get();
		lineDAO.asociarAreaALineas(weff, areaConfR);
		*/
		
		
	}

}
