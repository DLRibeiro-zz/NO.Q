package gui.html;

public class HomeHTML {

  String html = "<!doctype html>\n"
      + "<html lang=\"pt-br\">\n"
      + "  <head>\n"
      + "    <!-- Required meta tags -->\n"
      + "    <meta charset=\"utf-8\">\n"
      + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
      + "\n"
      + "    <!-- Bootstrap CSS -->\n"
      + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n"
      + "    <style>\n"
      + "        .navbar {\n"
      + "  color: #c51919;\n"
      + "  background-color: #e9c4de;\n"
      + "}\n"
      + "\n"
      + ".nav-link {\n"
      + "  color: #c51919;\n"
      + "}\n"
      + "\n"
      + ".card-title {\n"
      + "  color: #c51919;\n"
      + "}\n"
      + "\n"
      + ".nav {\n"
      + "  color: #FFFFFF;\n"
      + "  background-color: #CC3333;\n"
      + "}\n"
      + "\n"
      + ".card {\n"
      + "  background: #f0dfec;\n"
      + "}\n"
      + "    </style>\n"
      + "\n"
      + "    <!-- Optional JavaScript -->\n"
      + "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n"
      + "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n"
      + "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n"
      + "    <title>No Q</title>\n"
      + "  </head>\n"
      + "  <body>\n"
      + "    <nav class=\"navbar navbar-fixed-top navbar-expand-lg \">\n"
      + "        <div class=\"container\"> \n"
      + "            <a class=\"navbar-brand h1 mb-0\" href=\"index.html\">\n"
      + "                <img src=\"https://i.imgur.com/qG71wOq.png\" height=\"45\" width=\"70\" alt=\"\">\n"
      + "            </a>\n"
      + "            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSite\">\n"
      + "                <span class=\"navbar-toggler-icon\"></span>\n"
      + "            </button>\n"
      + "            <div class=\"collapse navbar-collapse\" id=\"navbarSite\">\n"
      + "                <ul class=\"navbar-nav ml-auto\">\n"
      + "                    <li class=\"nav-item\">\n"
      + "                        <a class=\"navbar-brand h1 mb-0\" href=\"#\">\n"
      + "                                <img src=\"https://i.imgur.com/ABhNqvX.png\" height=\"40\" width=\"40\" alt=\"\">\n"
      + "                        </a>\n"
      + "                    </li>\n"
      + "                    <li class=\"nav-item\">\n"
      + "                            <a class=\"nav-link\" href=\"/listar/prato\">Pratos</a>\n"
      + "                    </li>\n"
      + "                    <li class=\"nav-item\">\n"
      + "                            <a class=\"nav-link\" href=\"#\">Sair</a>\n"
      + "                    </li>\n"
      + "                </ul>\n"
      + "            </div>\n"
      + "        </div>\n"
      + "    </nav>\n"
      + "    <div class=\"container\"> <p></p></div>\n"
      + "\n"
      + "\n"
      + "  </body>\n"
      + "</html>";

  public String getHtml() {
    return this.html;
  }
}
