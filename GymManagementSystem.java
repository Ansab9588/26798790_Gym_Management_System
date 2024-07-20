import java.util.List;
import java.util.Scanner;

public class GymManagementSystem {
        // Scanner for reading user input
    private static Scanner scanner = new Scanner(System.in);
    private static MemberDAO memberDAO = new MemberDAO();
    private static TrainerDAO trainerDAO = new TrainerDAO();
    private static ClassScheduleDAO classScheduleDAO = new ClassScheduleDAO();

    public static void main(String[] args) {
        // Infinite loop for displaying the main menu
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    manageMembers();
                    break;
                case 2:
                    manageTrainers();
                    break;
                case 3:
                    manageClassSchedules();
                    break;
                case 4:
                    System.exit(0);   // Exit the application
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("Gym Management System");
        System.out.println("1. Member Management");
        System.out.println("2. Trainer Management");
        System.out.println("3. Class Schedule Management");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void manageMembers() {
        while (true) {
            System.out.println("Member Management");
            System.out.println("1. Register new member");
            System.out.println("2. View member details");
            System.out.println("3. Update member information");
            System.out.println("4. Delete member");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    viewMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    // Register new members
    private static void registerMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter membership type: ");
        String membershipType = scanner.nextLine();
        Member member = new Member();
        member.setName(name);
        member.setContactNumber(contactNumber);
        member.setEmail(email);
        member.setMembershipType(membershipType);
        memberDAO.addMember(member);
        System.out.println("Member registered successfully.");
    }

    private static void viewMember() {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        Member member = memberDAO.getMember(memberId);
        if (member != null) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Contact Number: " + member.getContactNumber());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Membership Type: " + member.getMembershipType());
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void updateMember() {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Member member = memberDAO.getMember(memberId);
        if (member != null) {
            System.out.print("Enter new name (or leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                member.setName(name);
            }
            System.out.print("Enter new contact number (or leave blank to keep current): ");
            String contactNumber = scanner.nextLine();
            if (!contactNumber.isEmpty()) {
                member.setContactNumber(contactNumber);
            }
            System.out.print("Enter new email (or leave blank to keep current): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                member.setEmail(email);
            }
            System.out.print("Enter new membership type (or leave blank to keep current): ");
            String membershipType = scanner.nextLine();
            if (!membershipType.isEmpty()) {
                member.setMembershipType(membershipType);
            }
            memberDAO.updateMember(member);
            System.out.println("Member updated successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void deleteMember() {
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        memberDAO.deleteMember(memberId);
        System.out.println("Member deleted successfully.");
    }

    private static void manageTrainers() {
        while (true) {
            System.out.println("Trainer Management");
            System.out.println("1. Add new trainer");
            System.out.println("2. View trainer details");
            System.out.println("3. Update trainer information");
            System.out.println("4. Delete trainer");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addTrainer();
                    break;
                case 2:
                    viewTrainer();
                    break;
                case 3:
                    updateTrainer();
                    break;
                case 4:
                    deleteTrainer();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTrainer() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter speciality: ");
        String speciality = scanner.nextLine();
        Trainer trainer = new Trainer();
        trainer.setName(name);
        trainer.setContactNumber(contactNumber);
        trainer.setEmail(email);
        trainer.setSpeciality(speciality);
        trainerDAO.addTrainer(trainer);
        System.out.println("Trainer added successfully.");
    }

    private static void viewTrainer() {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        Trainer trainer = trainerDAO.getTrainer(trainerId);
        if (trainer != null) {
            System.out.println("Trainer ID: " + trainer.getTrainerId());
            System.out.println("Name: " + trainer.getName());
            System.out.println("Contact Number: " + trainer.getContactNumber());
            System.out.println("Email: " + trainer.getEmail());
            System.out.println("Speciality: " + trainer.getSpeciality());
        } else {
            System.out.println("Trainer not found.");
        }
    }

    private static void updateTrainer() {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Trainer trainer = trainerDAO.getTrainer(trainerId);
        if (trainer != null) {
            System.out.print("Enter new name (or leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                trainer.setName(name);
            }
            System.out.print("Enter new contact number (or leave blank to keep current): ");
            String contactNumber = scanner.nextLine();
            if (!contactNumber.isEmpty()) {
                trainer.setContactNumber(contactNumber);
            }
            System.out.print("Enter new email (or leave blank to keep current): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                trainer.setEmail(email);
            }
            System.out.print("Enter new speciality (or leave blank to keep current): ");
            String speciality = scanner.nextLine();
            if (!speciality.isEmpty()) {
                trainer.setSpeciality(speciality);
            }
            trainerDAO.updateTrainer(trainer);
            System.out.println("Trainer updated successfully.");
        } else {
            System.out.println("Trainer not found.");
        }
    }

    private static void deleteTrainer() {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        trainerDAO.deleteTrainer(trainerId);
        System.out.println("Trainer deleted successfully.");
    }

    private static void manageClassSchedules() {
        while (true) {
            System.out.println("Class Schedule Management");
            System.out.println("1. Create new class schedule");
            System.out.println("2. View class schedules");
            System.out.println("3. Update class schedule");
            System.out.println("4. Cancel class");
            System.out.println("5. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    createClassSchedule();
                    break;
                case 2:
                    viewClassSchedules();
                    break;
                case 3:
                    updateClassSchedule();
                    break;
                case 4:
                    cancelClass();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createClassSchedule() {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter day of week: ");
        String dayOfWeek = scanner.nextLine();
        System.out.print("Enter start time (HH:MM:SS): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM:SS): ");
        String endTime = scanner.nextLine();
        ClassSchedule classSchedule = new ClassSchedule();
        classSchedule.setClassName(className);
        classSchedule.setTrainerId(trainerId);
        classSchedule.setDayOfWeek(dayOfWeek);
        classSchedule.setStartTime(startTime);
        classSchedule.setEndTime(endTime);
        classScheduleDAO.addClassSchedule(classSchedule);
        System.out.println("Class schedule created successfully.");
    }

    private static void viewClassSchedules() {
        System.out.print("Enter trainer ID: ");
        int trainerId = scanner.nextInt();
        List<ClassSchedule> schedules = classScheduleDAO.getClassSchedulesByTrainer(trainerId);
        for (ClassSchedule schedule : schedules) {
            System.out.println("Schedule ID: " + schedule.getScheduleId());
            System.out.println("Class Name: " + schedule.getClassName());
            System.out.println("Day of Week: " + schedule.getDayOfWeek());
            System.out.println("Start Time: " + schedule.getStartTime());
            System.out.println("End Time: " + schedule.getEndTime());
        }
    }

    private static void updateClassSchedule() {
        System.out.print("Enter schedule ID: ");
        int scheduleId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        ClassSchedule schedule = classScheduleDAO.getClassSchedule(scheduleId);
        if (schedule != null) {
            System.out.print("Enter new class name (or leave blank to keep current): ");
            String className = scanner.nextLine();
            if (!className.isEmpty()) {
                schedule.setClassName(className);
            }
            System.out.print("Enter new trainer ID (or leave blank to keep current): ");
            String trainerId = scanner.nextLine();
            if (!trainerId.isEmpty()) {
                schedule.setTrainerId(Integer.parseInt(trainerId));
            }
            System.out.print("Enter new day of week (or leave blank to keep current): ");
            String dayOfWeek = scanner.nextLine();
            if (!dayOfWeek.isEmpty()) {
                schedule.setDayOfWeek(dayOfWeek);
            }
            System.out.print("Enter new start time (or leave blank to keep current): ");
            String startTime = scanner.nextLine();
            if (!startTime.isEmpty()) {
                schedule.setStartTime(startTime);
            }
            System.out.print("Enter new end time (or leave blank to keep current): ");
            String endTime = scanner.nextLine();
            if (!endTime.isEmpty()) {
                schedule.setEndTime(endTime);
            }
            classScheduleDAO.updateClassSchedule(schedule);
            System.out.println("Class schedule updated successfully.");
        } else {
            System.out.println("Schedule not found.");
        }
    }

    private static void cancelClass() {
        System.out.print("Enter schedule ID: ");
        int scheduleId = scanner.nextInt();
        classScheduleDAO.deleteClassSchedule(scheduleId);
        System.out.println("Class schedule canceled successfully.");
    }
}
