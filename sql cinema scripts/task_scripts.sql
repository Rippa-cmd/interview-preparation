# 1
with film_list as (
SELECT f.film_name as film, t.id as session_id, TIME(t.date) as time_start, ADDTIME((SELECT time_start), SEC_TO_TIME(fd.film_duration*60)) as time_end
FROM timetable t
	join films f
		on t.id_film=f.id_film
	join film_duration fd
		on f.id_duration=fd.id_duration)
select f1.film as `Фильм 1`, f1.time_start as `Время начала`, f1.time_end as `Время окончания`,
       f2.film as `Фильм 2`, f2.time_start as `Время начала`, f2.time_end as `Время окончания`
from film_list as f1
         join film_list as f2 on f1.time_start < f2.time_end and f1.time_end > f2.time_start and f1.session_id <> f2.session_id and f1.session_id < f2.session_id
order by 2;

#2
with film_list as (
SELECT f.film_name as film, t.id as session_id, TIME(t.date) as time_start, ADDTIME((SELECT time_start), SEC_TO_TIME(fd.film_duration*60)) as time_end
FROM timetable t
	join films f
		on t.id_film=f.id_film
	join film_duration fd
		on f.id_duration=fd.id_duration)
select f1.film as `Фильм 1`, f1.time_start as `Время начала`, f1.time_end as `Время окончания`,
       f2.film as `Фильм 2`, f2.time_start as `Время начала`, f2.time_end as `Время окончания`,
       TIMEDIFF(f1.time_end, f2.time_start) as `Время перерыва`
from film_list as f1
         join film_list as f2 on TIMEDIFF(f1.time_end, f2.time_start)>=SEC_TO_TIME(30*60)
order by 7;


# 3
with film_list as (
SELECT f.film_name as film, count(t.id) as all_timetables
FROM timetable t
	join films f
		on t.id_film=f.id_film
	group by film)
select f.film_name as film, count(tick.id_ticket) as vis, count(tick.id_ticket) / fl.all_timetables as average, sum(ROUND(dm.day_multiplier*tm.mutliplier*f.def_cost, -1)) as box
from films f
         join timetable t
              on t.id_film=f.id_film
         join day_multiplier dm
              on DAYNAME(t.date)=dm.day
         join time_multiplier tm
              on time(t.date)>=tm.time_from and time(t.date)<tm.time_to
    join tickets tick
on t.id=tick.id_timetable
    join film_list fl
    on f.film_name=fl.film
group by film with rollup;