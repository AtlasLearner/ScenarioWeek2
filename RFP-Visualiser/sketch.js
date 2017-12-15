var scaleXandY = 0.2;

//Change the scale accordingly - This is the value of 10 grid small boxes
var scaleValueX = scaleXandY;
var scaleValueY = scaleXandY;

//Change the canvas length accordingly. Canvas size = canvaslength^2
var canvasLength = 2050;


var scaleGridValueX = scaleValueX/10;
var scaleGridValueY = scaleValueY/10;

var scaleGridX = 5;
var scaleGridY = 5;

//Center of graph
var originX = canvasLength/2;
var originY = canvasLength/2;

//Amount of pixels 10 for 10 grid small boxes
var scaleX = 50;
var scaleY = 50;

String.prototype.replaceAll = function(search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};
//Solution to be pasted in solution string - Must be same format as solution
var solutionString = "1: (0, 0), (0.29389262614623657, 0), (0.29389262614623657, 0.29389262614623657), (0, 0.29389262614623657);"
var arrayOfShapesInRoom = [];
splitSolutionRoom(solutionString);

//Strings to handle shapes not in room
var shapesNotInRoom = "1: (0, 0), (-2, 0), (-2, 2), (0, 2);"
var arrayOfShapesNotInRoom = [];
splitSolutionNotInRoom(shapesNotInRoom);

//Room to be drawn - Must be in this format: 1: <coordinates> #;
var roomString = "4: (0, 0), (0.8526494162024667, 0.8092928915415593), (0.34644929796095963, 1.8702959318493564), (-0.8190489964239736, 1.7167389813849911), (-1.0331664379423868, 0.5608325264814319) #"
var roomCoordinates = splitRoom(roomString);


function setup() {
    canvas = createCanvas(canvasLength, canvasLength);
}

function draw() {
//Initialise the sketch
    background(255);

    drawGrid();
    drawPlot();

    //Draws all shapes in room
    stroke(255, 0, 0);
    drawAllShapes(arrayOfShapesInRoom);

    //Draws all shapes not in room
    //stroke(255, 0, 255);
    //drawAllShapes(arrayOfShapesNotInRoom);

    //Draws room
    stroke(0, 0, 255);
    drawShape(roomCoordinates);
    
}

function drawPlot() {
    //Colours plot black
    stroke(0, 0, 0)

    //Intialises the two axis
    line(canvas.width/2, 0, canvas.width/2, canvas.height);
    line(0, canvas.height/2, canvas.width, canvas.height/2);

    //Draw the Y-Scale
    for(var i = 0; i < 25; i ++) {
        if (i != 0) {
            line(canvas.width/2-4, canvas.height/2 + i * scaleY, canvas.width/2+4, canvas.height/2 + i * scaleY);
            line(canvas.width/2-4, canvas.height/2 - i * scaleY, canvas.width/2+4, canvas.height/2 - i * scaleY);
            text(float_fix(i * scaleValueY), canvas.width/2 - 18, canvas.height/2 - i * scaleY + 4);
            text(-float_fix(i * scaleValueY), canvas.width/2 - 21, canvas.height/2 + i * scaleY + 4);
        }
    }

    //Draws the X-Scale
    for(var i = 0; i < 25; i ++) {
        if (i != 0) {
            line(canvas.width/2 + i * scaleX, canvas.height/2 - 4, canvas.width/2 + i * scaleX, canvas.height/2 + 4);
            line(canvas.width/2 - i * scaleX, canvas.height/2 - 4, canvas.width/2 - i * scaleX, canvas.height/2 + 4);
            text(float_fix(i * scaleValueX), canvas.width/2 + i * scaleX - 7, canvas.height/2 + 17);
            text(-float_fix(i * scaleValueX), canvas.width/2 - i * scaleX - 8, canvas.height/2 + 17);
        }
    }

}

function drawGrid() {
    for (var i = 0; i < canvas.width/scaleGridX/2; i++) {
        if (i != 0 && i % scaleGridX !=0) {
            stroke(224);
            line(canvas.width/2 + scaleGridX * i, 0, canvas.width/2 + scaleGridX * i, canvas.height);
            line(canvas.width/2 - scaleGridX * i, 0, canvas.width/2 - scaleGridX * i, canvas.height);
        }
        else if (i != 0 &&i % scaleGridX == 0) {
            stroke(160);
            line(canvas.width/2 + scaleGridX * i, 0, canvas.width/2 + scaleGridX * i, canvas.height);
            line(canvas.width/2 - scaleGridX * i, 0, canvas.width/2 - scaleGridX * i, canvas.height);
        }
    }

    for (var i = 0; i < canvas.height/scaleGridY/2; i++) {
        if (i != 0 && i % scaleGridY !=0) {
            stroke(224);
            line(0, canvas.height/2 + i * scaleGridY, canvas.width, canvas.height/2 + i * scaleGridY);
            line(0, canvas.height/2 - i* scaleGridY, canvas.width, canvas.height/2 - i * scaleGridY);
        }
        else if (i != 0 && i % scaleGridY== 0) {
            stroke(160);
            line(0, canvas.height/2 + i * scaleGridY, canvas.width, canvas.height/2 + i * scaleGridY);
            line(0, canvas.height/2 - i * scaleGridY, canvas.width, canvas.height/2 - i * scaleGridY);
         }
    }

}

function float_fix(num) {
    //Rounds floating points
    return Math.round(num * 10000000) / 10000000;
}

function double_fix_three_dp(num) {
    return Math.round(num * 1000) / 1000;
}

function drawLine(x1, y1, x2, y2) {
    line(originX + scaleGridX * (x1/scaleGridValueX), originY - scaleGridY * (y1/scaleGridValueY), originX  + scaleGridX * (x2/scaleGridValueX), originY - scaleGridY * (y2/scaleGridValueY));
}

function drawShape(coordinatesOfShape) {
    var startX;
    var startY;
    startX = coordinatesOfShape[0];
    startY = coordinatesOfShape[1];
    for(var i = 0; i < (coordinatesOfShape.length); i+=2) {
        if(i == coordinatesOfShape.length - 2) {
            drawLine(coordinatesOfShape[i], coordinatesOfShape[i+1], startX, startY);
        }
        else {
            drawLine(coordinatesOfShape[i], coordinatesOfShape[i+1], coordinatesOfShape[i+2], coordinatesOfShape[i+3]);
        }
    }
}

function splitRoom(roomString) {
    var removeProblemNumber = roomString.split(": ");

    var noHashRoom = removeProblemNumber[1].split(" #");
    
    var tempRoom = noHashRoom[0].replaceAll("(", "");
    tempRoom = tempRoom.replaceAll(" ", "");
    tempRoom = tempRoom.replaceAll(")", "");

    var tempRoomCoordinates = tempRoom.split(",");
    return tempRoomCoordinates;
}

function splitSolutionRoom(solutionString) {
    var removeProblemNumber = solutionString.split(": ")
    removeProblemNumber.shift();
    

    var stringOfShapes = removeProblemNumber[0].split("; ");
    
    for(var i = 0; i < stringOfShapes.length; i++) {
        var tempShape = stringOfShapes[i].replaceAll("(", "");
        tempShape = tempShape.replaceAll(" ", "");
        tempShape = tempShape.replaceAll(")", "");
        tempShape = tempShape.replaceAll(";", "");
        
        var tempCoordinateOfShape = tempShape.split(",");
        arrayOfShapesInRoom[i] = tempCoordinateOfShape;
    }
}

function splitSolutionNotInRoom(solutionString) {
    var removeProblemNumber = solutionString.split(": ")
    removeProblemNumber.shift();
    

    var stringOfShapes = removeProblemNumber[0].split("; ");
    
    for(var i = 0; i < stringOfShapes.length; i++) {
        var tempShape = stringOfShapes[i].replaceAll("(", "");
        tempShape = tempShape.replaceAll(" ", "");
        tempShape = tempShape.replaceAll(")", "");
        tempShape = tempShape.replaceAll(";", "");
        console.log(tempShape);
        var tempCoordinateOfShape = tempShape.split(",");
        arrayOfShapesNotInRoom[i] = tempCoordinateOfShape;
    }
}

function drawAllShapes(arrayOfObjects) {
    for (var i = 0; i < arrayOfObjects.length; i++) {
        drawShape(arrayOfObjects[i]);
    };
}

