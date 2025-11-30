import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;
        for (int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int[] arr = new int[4];
            for (int j=0; j<4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            students.add(new Student(number, arr));
        } 

        for (Student student : students) {

            List<int[]> areas = findLikeStudentArea(student);
            // System.out.println("areas");

            // for (int[] area : areas) {
            //     System.out.println(Arrays.toString(area));
            // }
            List<int[]> findAreas = findEmptyArea(areas);

            if (findAreas.size() == 1) {
                // System.out.println("findArea 에서 끝");
                putStudent(findAreas.get(0), student);
            } else {
                List<int[]> columns = calColumn(findAreas);
                if (columns.size() == 1) {
                    // System.out.println("column에서 끝");
                    putStudent(columns.get(0), student);
                } else {
                    int[] finalArea = calRow(columns);
                    // System.out.println("row에서 끝");
                    putStudent(finalArea, student);
                }
            }

            // for (int i=0; i<N; i++) {
            //     for (int j=0; j<N; j++) {
            //         System.out.print(graph[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            // System.out.println();
        }

        int sufficient = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int targetStudent = graph[i][j];
                int count = 0;
                
                Student student = findStudent(targetStudent);
                for (int a = 0; a< 4; a++) {
                    int nx = i + dx[a];
                    int ny = j + dy[a];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }      
                    
                    if (student.hasLikeStudents(graph[nx][ny])) {
                        count ++;
                    }
                }
                if (count == 0) {
                    sufficient += 0;
                }
                if (count == 1) {
                    sufficient += 1;
                }
                if (count == 2) {
                    sufficient += 10;
                }
                if (count == 3) {
                    sufficient +=100;
                }
                if (count == 4) {
                    sufficient += 1000;
                }
            }
        }
        System.out.println(sufficient);

    }

    public static Student findStudent(int value) {
        for (Student student : students) {
            if (student.number == value) {
                return student;
            }
        }
        return null;
    }

    public static void putStudent(int[] target, Student student) {
        graph[target[0]][target[1]] = student.number;
        visited[target[0]][target[1]] = true;
    }


    public static List<int[]> findLikeStudentArea(Student targetStudent) {
        List<int[]> area = new ArrayList<>();
        int maxCount = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (visited[i][j] == true) {
                    continue;
                }

                int count = 0;
                for (int k=0; k<4; k++) {
                    int a = i + dx[k];
                    int b = j + dy[k];

                    if (a<0 || a>=N || b<0 || b>=N) {
                        continue;
                    }

                    if (targetStudent.hasLikeStudents(graph[a][b])) {
                        count++;
                    }
                }
                if (maxCount == count) {
                    area.add(new int[]{i,j});
                } else if(maxCount < count) {
                    maxCount = count;
                    area.clear();
                    area.add(new int[]{i,j});
                }
            }
        }
        return area;
    } 

    public static List<int[]> findEmptyArea(List<int[]> target) {
        List<int[]> result = new ArrayList<>();
        int maxCount = 0;
        for (int i=0; i<target.size(); i++) {
            int[] arr = target.get(i);
            if (visited[arr[0]][arr[1]]) {
                continue;
            }

            int currentCount = 0;
            for (int a = 0; a < 4; a++) {
                int nx = arr[0] + dx[a];
                int ny = arr[1] + dy[a];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    currentCount ++;
                }
            }
            if (maxCount < currentCount) {
                maxCount = currentCount;
                result.clear();
                result.add(target.get(i));
            } else if (maxCount == currentCount) {
                result.add(target.get(i));
            }
        }
    
        return result;
    }

    public static List<int[]> calColumn(List<int[]> target) {
        List<int[]> result = new ArrayList<>();

        int maxC = Integer.MAX_VALUE;
        for (int[] t : target) {
            if (visited[t[0]][t[1]]) {
                continue;
            }
            if (t[0] < maxC) {
                maxC = t[0];
                result.clear();
                result.add(t);
            } else if(t[0] == maxC) {
                result.add(t);
            }
        }
        return result;
    }

    public static int[] calRow(List<int[]> target) {
        int[] result = new int[2];
        int maxR = Integer.MAX_VALUE;
        for (int[] t : target) {
            if (visited[t[0]][t[1]]) {
                continue;
            }
            if (t[0] < maxR) {
                maxR = t[0];
                result = t;
            }
        }
        return result;
    }

    
}

class Student {
    public int number;
    public int[] likeStudents;

    public Student(int number, int[] likeStudents) {
        this.number = number;
        this.likeStudents = likeStudents;
    }

    public boolean hasLikeStudents(int target) {
        for (int i=0; i<likeStudents.length; i++) {
            if (likeStudents[i] == target) {
                return true;
            }
        }
        return false;
    }
 }