import java.util.Map;
import java.util.HashMap;
import spark.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hello.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/favorite_photos", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/favorite_photos.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/greeting_card", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String recipient = request.queryParams("recipient");
      String sender = request.queryParams("sender");
      model.put("recipient", recipient);
      model.put("sender", sender);
      model.put("template", "templates/greeting_card.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

// public class App {
//   public static void main(String[] args) {
//     staticFileLocation("/public");
//     get("/", (request, response) ->
//         "<!DOCTYPE html>" +
//          "<html>" +
//          "<head>" +
//            "<title>Bonjour Friend!</title>" +
//            "<link rel='stylesheet' + href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
//          "</head>" +
//         "<body>" +
//            "<h1>Hello From Afar</h1>" +
//            "<p>Dear Friend,</p>" +
//            "<p>How are you? I hope that you are having a nice weekend. I'm vacationing in Switzerland while I learn programming! </p>" +
//            "<p>Friend, you would not believe how cold it is here. I should have gone to Hawaii instead.</p>" +
//            "<p>But I like programming a lot, so I've got that going for me. </p>" +
//            "<p>Looking forward to seeing you soon. I'll bring you back a souvenir. </p>" +
//            "<p>Cheers,</p>" +
//            "<p>Travel Enthusiast Blake</p>" +
//            "<p><a href='/favorite_photos' >P.S. Check out my favorite travel photos here.</a></p>" +
//          "</body>" +
//        "</html>"
//     );

    // get("/favorite_photos", (request, response) ->
    // "<!DOCTYPE html>" +
    //   "<html>" +
    //   "<head>" +
    //     "<title>Hello Friend!</title>" +
    //     "<link rel='stylesheet'  href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>" +
    //   "</head>" +
    //   "<body>" +
    //    "<h1>Favorite Traveling Photos</h1>" +
    //       "<ul>" +
    //         "<li><img src='/images/eila-lifflander-220723.jpg' alt='A photo of a mountain.'/></li>" +
    //         "<li><img src='/images/joshua-earle-35836.jpg' alt='A photo of a mountain.'/></li>" +
    //       "</ul>" +
    //   "</body>" +
    //   "</html>"
    // );
  }
}
