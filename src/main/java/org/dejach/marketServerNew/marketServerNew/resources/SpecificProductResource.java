package org.dejach.marketServerNew.marketServerNew.resources;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.dejach.marketApi.MarketApi;
import org.dejach.marketApi.MarketApiExceptions;
import org.dejach.marketApi.SpecificProductApi;

@Path("/specificProduct")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpecificProductResource {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory( "marketApi" );
	static EntityManager em= emf.createEntityManager();
    MarketApi marketApi = new MarketApi();
	SpecificProductApi specificProductApi1 = new SpecificProductApi();
	@GET
	@Path("/spv/{specificProductId}")
	public SpecificProductApi viewSpecificProduct(@PathParam("specificProductId") String id) throws MarketApiExceptions{
		MarketApi.setEm(em);
		SpecificProductApi viewedSpecificProductApi = this.marketApi.viewSpecificProduct(id);
		return viewedSpecificProductApi;
	}
	@GET
	@Path("/spva/{specificProductId}")
	public List<SpecificProductApi> viewSpecificProducts(@PathParam("specificProductId") String id) throws MarketApiExceptions{
		MarketApi.setEm(em);
		List<SpecificProductApi> viewedSpecificProductApis = this.marketApi.viewSpecificProducts(id);
		return viewedSpecificProductApis;
	}
	@POST
	@Path("/spa")
	public void addSpecificProduct(SpecificProductApi specificProductApi) throws MarketApiExceptions{
		MarketApi.setEm(em);		
		this.marketApi.addSpecificProduct(specificProductApi);
	}
	@POST
	@Path("/spd/{specificProductId}")
	public void deleteSpecificProduct(@PathParam("specificProductId") String id) throws MarketApiExceptions{
		MarketApi.setEm(em);		
		this.marketApi.deleteSpecificProduct(id);
	}
	@POST
	@Path("/spu")
	public void updateSpecificProduct(SpecificProductApi specificProductApi) throws MarketApiExceptions{
		MarketApi.setEm(em);		
		this.marketApi.updateSpecificProduct(specificProductApi);
	}
	//getting cookies and url
	@POST
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		//String cookies = headers.getCookies().toString();
		return "Path : "+path;
		
	}
	/*@Path("/{specificProductId}/comments")
	public CommentResource getCommentResource(SpecificProductApi specificProductApi) throws MarketApiExceptions{
		return new CommentResource();
	}*/
	
}
