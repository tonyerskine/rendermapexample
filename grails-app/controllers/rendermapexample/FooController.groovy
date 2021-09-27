package rendermapexample

class FooController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        Map<String, Breakfast> mealsByPerson = [
            Tom: new Breakfast(meat: "bacon", eggs: "scrambled", side: "hashbrowns"),
            Jack: new Breakfast(meat: "sausage", eggs: "over easy", side: "pancakes")
        ]

        render template: "foo", model: [
            cost: 12.34f,
            date: new Date(),
            mealsByPerson: mealsByPerson,
            allCaps: params.boolean("allCaps")
        ]
    }
}

/*
This is what I'm looking for:
    {
        "cost": 12.34,
        "date": "2021-09-25T01:11:39Z",
        "mealsByPerson": {
            "Tom": {
                "eggs": "scrambled",
                "meat": "bacon",
                "side": "hashbrowns"
            },
            "Jack": {
                "eggs": "over easy",
                "meat": "sausage",
                "side": "pancakes"
            }
        }
    }

The render statement below creates the JSON I want in this simple example,
but my real world problem needs more control over rendering than 'as JSON' provides
render ([cost: 12.34f, date: new Date(), mealsByPerson: mealsByPerson] as JSON)

 */