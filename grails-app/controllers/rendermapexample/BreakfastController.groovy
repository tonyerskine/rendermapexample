package rendermapexample

class BreakfastController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        Breakfast breakfast = new Breakfast(meat: "bacon", eggs: "scrambled", side: "hashbrowns")
        respond breakfast, model: [allCaps: params.boolean("allCaps")]
    }
}
