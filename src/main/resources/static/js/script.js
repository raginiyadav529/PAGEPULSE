
    const button = document.getElementById("analyzeBtn");
     button.addEventListener("click", async function () {

     button.disabled = true;
     button.textContent = "⏳ Analyzing...";

     document.getElementById("errorMessage").textContent = "";
     document.getElementById("status").textContent = "";

      // Clear previous results
         document.getElementById("responseTime").textContent = "";
         document.getElementById("title").textContent = "";
         document.getElementById("metaDescription").textContent = "";
         document.getElementById("h1Count").textContent = "";
         document.getElementById("imagesMissingAlt").textContent = "";
         document.getElementById("wordCount").textContent = "";

     const url = document.getElementById("url").value;
    try{

            console.log(url);

            const response = await fetch("/analyze", {  // Wait for backend
                       method: "POST",

                       headers: {
                            "Content-Type": "application/json"
                       },

                       body: JSON.stringify({
                            url: url
                       })
            });

            // If backend returns 400 or 500
           if (!response.ok) {
               document.getElementById("status").textContent = "";
               const errorMessage = await response.text();
              document.getElementById("errorMessage").textContent = errorMessage;
               button.disabled = false;
               button.textContent = "Analyze Website";
               return;
           }


           // success
            const data = await response.json();  // Read the JSON response from the backend
            //console.log(data);

            const statusElement = document.getElementById("status");

            statusElement.textContent = data.status;

            if (data.status === 200) {
                statusElement.style.color = "green";
            } else {
                statusElement.style.color = "red";
            }

             document.getElementById("responseTime").textContent = data.responseTime+" ms";
             document.getElementById("title").textContent = data.title;
             document.getElementById("metaDescription").textContent = data.metaDescription;
             document.getElementById("h1Count").textContent = data.h1Count;
             document.getElementById("imagesMissingAlt").textContent = data.imagesMissingAlt;
             document.getElementById("wordCount").textContent = data.wordCount;
    }
     catch (error) {

             document.getElementById("status").textContent = "";
             document.getElementById("errorMessage").textContent =
                 "Something went wrong. Please try again.";
     }
     finally {

         button.disabled = false;
         button.textContent = "🔍 Analyze Website";

     }
});

