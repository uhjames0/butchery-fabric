package net.mcreator.butchery.procedures;

import net.mcreator.butchery.ButcheryMod;
import net.mcreator.butchery.init.ButcheryModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class BlooddrippingProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        block8: {
            block7: {
                block6: {
                    int n;
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                    Property property = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                    if (property instanceof IntegerProperty) {
                        Property<?> _getip3 = (IntegerProperty)property;
                        n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip3);
                    } else {
                        n = -1;
                    }
                    if (n == 1) break block7;
                }
                if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
            }
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
            }
            ButcheryMod.queueServerWork(5, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                }
            });
            ButcheryMod.queueServerWork(10, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                }
            });
            ButcheryMod.queueServerWork(15, () -> {
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                }
            });
        }
        ButcheryMod.queueServerWork(28, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip16 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip16);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(56, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip30 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip30);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(84, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip44 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip44);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(112, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip58 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip58);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(140, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip72 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip72);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(168, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip86 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip86);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(196, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip100 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip100);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(224, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip114 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip114);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(252, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip128 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip128);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(280, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip142 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip142);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(308, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip156 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip156);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(336, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip170 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip170);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(364, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip184 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip184);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(392, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip198 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip198);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(420, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip212 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip212);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(448, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip226 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip226);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(476, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip240 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip240);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(504, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip254 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip254);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(532, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip268 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip268);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(560, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip282 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip282);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(588, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip296 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip296);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(616, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip310 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip310);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(644, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip324 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip324);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(672, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip338 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip338);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(700, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip352 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip352);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(728, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip366 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip366);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(756, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip380 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip380);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(784, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip394 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip394);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(812, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip408 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip408);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(840, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            Property<?> _getip422 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip422);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
        ButcheryMod.queueServerWork(868, () -> {
            block8: {
                block7: {
                    block6: {
                        int n;
                        if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass")))) break block6;
                        Property patt0$temp = world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock().getStateDefinition().getProperty("blockstate");
                        if (patt0$temp instanceof IntegerProperty) {
                            IntegerProperty _getip436 = (IntegerProperty)patt0$temp;
                            n = (Integer)world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getValue((Property)_getip436);
                        } else {
                            n = -1;
                        }
                        if (n == 1) break block7;
                    }
                    if (!world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).is(TagKey.create((ResourceKey)Registries.BLOCK, (Identifier)Identifier.parse((String)"butchery:carcass_no_states")))) break block8;
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.5, y - 0.6, z + 0.5, 1, 0.0, 0.1, 0.0, 0.1);
                }
                ButcheryMod.queueServerWork(5, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(10, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.6, y - 0.6, z + 0.4, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
                ButcheryMod.queueServerWork(15, () -> {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((ParticleOptions)ButcheryModParticleTypes.BLOOD_PARTICLE.get(), x + 0.4, y - 0.6, z + 0.6, 1, 0.0, 0.1, 0.0, 0.1);
                    }
                });
            }
        });
    }
}

