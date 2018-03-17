package resources;

import com.google.gson.Gson;
import dao.NotaDaoImpl;
import interfaces.NotaDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Nota;

/**
 *
 * @author lyndemberg
 */
@Path("/notas")
public class NotaResource {
    private NotaDao dao;
    
    @PostConstruct
    public void init(){
        dao = new NotaDaoImpl();
    }
    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String salvar(Nota nova){
        if(dao.salvar(nova)){
            return "Nota salva com sucesso!";
        }else{
            return "Já existe essa nota salva";
        }
    }
    
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Nota buscarNota(@PathParam("id") int id){
        return dao.buscar(id);
    }
    
    @PUT
    @Path("/edit")
    @Produces(MediaType.TEXT_PLAIN)
    public String editarNota(Nota nota){
        dao.atualizar(nota);
        return "Nota atualizada com sucesso!";
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletarNota(@PathParam("id") int id){
        dao.delete(id);
        return "Nota removida com sucesso!";
    }
    
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Nota> listarTodas(){
        return dao.list();
    }
    
    
}
