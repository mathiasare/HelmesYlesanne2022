const API_URL = "http://localhost:8080/sector/all";

const getSectors = () => {
    fetchSectors().then(data => {
        createOptions(data.sectors)
    })
}

function createOptions(sectors) {
    let queue = []
    let options = document.getElementById("select-sectors").options
    let input = sectors.map(sector => {return [0, sector] })
    queue.push(...input)
    while(queue.length > 0) {
        const current = queue.shift()
        const [idx, sector] = current

        let optionElement = new Option(sector.name, sector.sector_id)
        optionElement.setAttribute("style", `text-indent: ${(idx*3)}rem`)

        options[options.length] = optionElement
        
        if(sector.children != null && sector.children.length > 0) {
            input = sector.children.map(sector => {return [(idx + 1), sector] })
            queue.unshift(...input)
        }
    }
}

async function fetchSectors() {
   let response = await fetch(`${API_URL}`, {
        method: "GET",
      })

    let data = await response.json()

    return data;
}

getSectors()