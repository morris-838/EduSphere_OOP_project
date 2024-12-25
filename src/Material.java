public class Material {
    private int materialID;
    private int courseID;
    private String contentType;
    private String content;
    public Material(int materialID,int courseID,String contentType,String content){
        this.materialID=materialID;
        this.courseID=courseID;
        this.contentType=contentType;
        this.content=content;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void viewMaterial(){
        System.out.println("Material type: "+contentType);
        System.out.println("content: "+content);
    }
}
