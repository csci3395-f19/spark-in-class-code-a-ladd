package basics

case class TempRow(day: Int, doy: Int, month: Int, year: Int, precip: Double, tave: Double, tmax: Double, tmin: Double)

object SATemps {

def parseLine(line: String): TempRow = {
  val p = line.split(",");
  TempRow(p(0).toInt, p(1).toInt, p(2).toInt, p(4).toInt, p(5).toDouble, p(6).toDouble, p(7).toDouble, p(8).toDouble);
}

def main(args: Array[String]): Unit = {
    val source = scala.io.Source.fromFile("/users/mlewis/CSCI3395-F19/InClassDB/SanAntonioTemps.csv");
    val lines = source.getLines();
    val data = lines.drop(2).map(parseLine).toArray;


    //testing my meager remaining scala knowledge
    val hottestDay = data.maxBy(_.tmax);
    //alt method! neither of them resolve ties correctly
    val hottestDay2 = data.reduce((d1,d2) => if(d1.tmax > d2.tmax) d1 else d2);

    val mostRain = data.maxBy(_.precip);


}

}