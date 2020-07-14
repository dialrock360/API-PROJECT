package com.yemmback.store.repository;


/**
 * Created by dialrock361 on 01/08/20.
 */

public  interface BasicRepository  {

     int deleteOrRestor(String tablename,String id,int flag,Boolean withflag);


}

/*

  if(newConditioning.getId()==null){
          if(conditioningRepository.existsConditioningByConditioningname(newConditioning.getConditioningname().toLowerCase())) {
          return new ResponseEntity(new ApiResponse(false, "Conditioning name is already taken!"),
          HttpStatus.BAD_REQUEST);
          }


          this.conditioning = new Conditioning(newConditioning.getConditioningname().toLowerCase(),0, null) ;
          }else {
          this.conditioning=conditioningRepository.getOne(newConditioning.getId());
          if(this.conditioning.getId()>0){
          this.conditioning.setConditioningname(newConditioning.getConditioningname().toLowerCase());
          this.conditioning.setFlag(newConditioning.getFlag());
          }
          }

          try {
          this.conditioning = conditioningRepository.save(this.conditioning);
          } catch (DataIntegrityViolationException ex) {
          logger.info("Sorry {} has not save in Conditioning {}", newConditioning.getConditioningname(), this.conditioning.getConditioningname());
          throw new BadRequestException("Sorry! BadRequestException in this Save: "+ex.toString());
          }
          return ResponseEntity.created(apir.location(this.conditioning.getConditioningname(),"/conditioning")).body(new ApiResponse(true, "Conditioning saved successfully "+String.valueOf(conditioning.getId())));


 */