package servicios;

import DAO.PatologiaDAO;
import DTO.PatologiaDTO;

public class PatologiaService {

	
	public PatologiaDTO buscarPatologiaPorId (int id)
	{
		PatologiaDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			pdto = pdao.buscarPorId(id);
		
		return pdto;
	}
}
