package wynk.servelet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.FollowerService;
import service.SongService;
import wynk.beans.Song;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Copyright (C) 2018 Scupids - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * @author vidisha
 */
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("panel/configuration/ui")
public class WynkRestAPI extends HttpServlet {

    @Autowired
    private FollowerService followerService;
    @Autowired
    private SongService songService;

    public void init() throws ServletException {
        // Do required initialization
    }

    @POST
    @Path("/{userId}")
    public void follow(@PathParam("userId") String userId, @QueryParam("followerId") String followerId) {
        followerService.follow(userId, followerId);
    }

    @POST
    @Path("/{userId}")
    public void unfollow(@PathParam("userId") String userId, @QueryParam("followerId") String followerId) {
        followerService.unfollow(userId, followerId);
    }

    @POST
    @Path("/")
    public Response publishSong(Song song) {
        songService.addSong(song);
        return Response.ok().build();
    }

    @POST
    @Path("/count/{artistId}")
    public Response getFollowerCount(@PathParam("artistId") String userId) {
        return Response.ok(followerService.getCount(userId)).build();
    }


}
