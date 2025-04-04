package Grupo6.src.sistemaDeGuardado;
//tengo que cambiar cosas aquí
//import org.json.JSONObject;
//import org.json.XML;

public class AdaptadorXMLtoJSON  {//implements JSONData
    private AlmacenXML XMLData;

    public AdaptadorXMLtoJSON(AlmacenXML xml) {
        this.XMLData= xml;
    }

    //@Override
    public void getJSON() {
        String xml = XMLData.toString();
        //JSONObject json = XML.toJSONObject(xml);
       // return json.toString();
    }
}
